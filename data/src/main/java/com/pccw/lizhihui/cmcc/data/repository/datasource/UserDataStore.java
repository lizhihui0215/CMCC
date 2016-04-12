package com.pccw.lizhihui.cmcc.data.repository.datasource;

import com.pccw.lizhihui.cmcc.data.entity.LoginParameters;
import com.pccw.lizhihui.cmcc.data.entity.UserEntity;

import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public interface UserDataStore {

    Observable<UserEntity> user(String username, String password);
}
