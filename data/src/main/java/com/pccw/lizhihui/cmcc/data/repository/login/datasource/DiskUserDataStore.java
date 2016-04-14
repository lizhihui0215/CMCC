package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import com.pccw.lizhihui.cmcc.domain.User;

import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 */
public class DiskUserDataStore implements UserDataStore {
    @Override
    public Observable<User> user(String username, String password) {
        return null;
    }
}
