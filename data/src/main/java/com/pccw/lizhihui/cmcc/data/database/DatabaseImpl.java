package com.pccw.lizhihui.cmcc.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.pccw.lizhihui.cmcc.data.greendao.gen.DaoMaster;
import com.pccw.lizhihui.cmcc.data.greendao.gen.DaoSession;

import javax.inject.Inject;

import de.greenrobot.dao.AbstractDao;

/**
 * Created by lizhihui on 4/14/16.
 *
 */
public class DatabaseImpl implements Database {
    private SQLiteDatabase db;

    private DaoMaster daoMaster;

    private DaoSession daoSession;

    @Inject
    public DatabaseImpl(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "cmcc.db",null);

        this.db =  helper.getWritableDatabase();

        String path = this.db.getPath();

        this.daoMaster = new DaoMaster(db);

        this.daoSession = this.daoMaster.newSession();

        this.daoSession.getUserEntityDao();

        this.daoSession.getDepartmentEntityDao();
    }

    @Override
    public void call(DBAction1 action1, Object entity) {
        AbstractDao<?, ?> dao = this.daoSession.getDao(entity.getClass());

        action1.call(dao,entity);
    }
}
