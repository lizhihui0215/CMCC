package com.pccw.lizhihui.cmcc.data.repository.datasource;

import com.pccw.lizhihui.cmcc.data.entity.LoginParameters;
import com.pccw.lizhihui.cmcc.data.entity.UserEntity;
import com.pccw.lizhihui.cmcc.domain.User;

import javax.inject.Inject;

/**
 * Created by lizhihui on 4/1/16.
 */
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper(){}

    public User transform(UserEntity userEntity) {

        User user = new User();
        user.name = "xxx";
        return user;
    }
}
