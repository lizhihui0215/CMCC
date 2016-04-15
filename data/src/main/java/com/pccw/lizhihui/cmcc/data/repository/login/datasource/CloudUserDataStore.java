package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import android.content.Entity;

import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.database.DBAction1;
import com.pccw.lizhihui.cmcc.data.database.Database;
import com.pccw.lizhihui.cmcc.data.greendao.gen.DepartmentEntity;
import com.pccw.lizhihui.cmcc.data.greendao.gen.DepartmentEntityDao;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntityDao;
import com.pccw.lizhihui.cmcc.data.net.NetworkServices;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public class CloudUserDataStore implements UserDataStore {

    private NetworkServices networkServices;

    private UserCache userCache;

    private Database database;

    private final DBAction1<UserEntityDao, UserEntity> saveUserToDBAction = AbstractDao::insert;

    private final DBAction1<DepartmentEntityDao,List<DepartmentEntity>> saveDepartmentToDBAction = (departmentEntityDao, departmentEntitys) -> {
        departmentEntityDao.insertInTx(departmentEntitys);
    };

    private final Action1<UserEntity> saveToCacheAction = user -> {
        if (user != null){
            try {
                this.userCache.put(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.saveToDB(user);

            this.networkServices.setLoginUser(user);
        }
    };

    public CloudUserDataStore(NetworkServices networkServices,UserCache userCache, Database database) {
        this.networkServices = networkServices;
        this.userCache = userCache;
        this.database = database;
    }

    @SuppressWarnings("unchecked")
    private void saveToDB(UserEntity user) {
        this.database.call(this.saveUserToDBAction, user);

        List<DepartmentEntity> deptList = user.getDeptList();

        for (DepartmentEntity departmentEntity : deptList) departmentEntity.setDepartmentId(user.getId());

        this.database.call(CloudUserDataStore.this.saveDepartmentToDBAction,deptList);
    }

    @Override
    public Observable<UserEntity> user(String username, String password) {
        return this.networkServices.userEntityBy(username,password).doOnNext(this.saveToCacheAction);
    }
}
