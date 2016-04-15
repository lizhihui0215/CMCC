package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.database.DBAction1;
import com.pccw.lizhihui.cmcc.data.database.Database;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntityDao;
import com.pccw.lizhihui.cmcc.data.net.NetworkServices;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public class CloudUserDataStore implements UserDataStore {

    private final NetworkServices networkServices;

    private final UserCache userCache;

    private final Database database;

    private final DBAction1<UserEntityDao, UserEntity> saveToDBAction = (userEntityDao, userEntity) -> {
        userEntityDao.insert(userEntity);
    };

    private final Action1<UserEntity> saveToCacheAction = user -> {
        if (user != null){
            try {
                CloudUserDataStore.this.userCache.put(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            CloudUserDataStore.this.database.call(this.saveToDBAction, user);

            CloudUserDataStore.this.networkServices.setLoginUser(user);
        }
    };

    public CloudUserDataStore(NetworkServices networkServices,UserCache userCache, Database database) {
        this.networkServices = networkServices;
        this.userCache = userCache;
        this.database = database;
    }

    @Override
    public Observable<UserEntity> user(String username, String password) {
        return this.networkServices.userEntityBy(username,password).doOnNext(this.saveToCacheAction);
    }
}
