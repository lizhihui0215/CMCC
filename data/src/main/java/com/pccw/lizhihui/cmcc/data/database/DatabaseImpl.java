package com.pccw.lizhihui.cmcc.data.database;

import android.content.Context;
import android.content.Entity;
import android.database.sqlite.SQLiteDatabase;

import com.pccw.lizhihui.cmcc.data.greendao.gen.DaoMaster;
import com.pccw.lizhihui.cmcc.data.greendao.gen.DaoSession;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.query.QueryBuilder;

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

        QueryBuilder.LOG_SQL = true;

        QueryBuilder.LOG_VALUES = true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void call(DBAction1 action1, Object entity) {
        AbstractDao<?, ?> dao = this.daoSession.getDao(entity.getClass());

        action1.call(dao,entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void call(DBAction1 action1, List list) {
        Object entity = list.isEmpty() ?  null : list.get(0);

        if (entity == null) return;

        AbstractDao<?, ?> dao = this.daoSession.getDao(entity.getClass());

        action1.call(dao, list);
    }
}
