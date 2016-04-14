package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import com.pccw.lizhihui.cmcc.domain.User;

import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public interface UserDataStore {

    Observable<User> user(String username, String password);
}
