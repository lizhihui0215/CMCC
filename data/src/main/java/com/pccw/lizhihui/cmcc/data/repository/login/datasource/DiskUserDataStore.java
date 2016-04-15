package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;

import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 */
public class DiskUserDataStore implements UserDataStore {
    @Override
    public Observable<UserEntity> user(String username, String password) {
        return null;
    }
}
