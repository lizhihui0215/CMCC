package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import com.pccw.lizhihui.cmcc.domain.User;

import javax.inject.Inject;

/**
 * Created by lizhihui on 4/1/16.
 */
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper(){}


    public User transform(User user) {
        return user;
    }
}
