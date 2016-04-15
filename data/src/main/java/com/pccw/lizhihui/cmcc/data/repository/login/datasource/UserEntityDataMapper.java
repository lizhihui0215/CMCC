package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import com.pccw.lizhihui.cmcc.data.greendao.gen.DepartmentEntity;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;
import com.pccw.lizhihui.cmcc.domain.User;
import com.pccw.lizhihui.cmcc.domain.User.Deparment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhihui on 4/1/16.
 */
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper(){}


    public User transform(UserEntity userEntity) {
        User user = new User();

        user.setAccessToken(userEntity.getAccessToken());
        user.setAccount(userEntity.getAccessToken());
        user.setDeptList(transform(userEntity.getDeptList(),user));


        return user;
    }

    public List<Deparment> transform(List<DepartmentEntity> departmentEntities, User user){

        List<Deparment> deparments = new ArrayList<>();

        for (DepartmentEntity departmentEntity: departmentEntities) {
            deparments.add(transform(departmentEntity,user));
        }

        return deparments;
    }

    private Deparment transform(DepartmentEntity departmentEntity, User user) {
        Deparment deparment =  user.new Deparment();


        return deparment;
    }
}
