package com.pccw.lizhihui.cmcc.data.repository;

import com.pccw.lizhihui.cmcc.data.repository.datasource.UserDataStore;
import com.pccw.lizhihui.cmcc.data.repository.datasource.UserDataStoreFactory;
import com.pccw.lizhihui.cmcc.data.repository.datasource.UserEntityDataMapper;
import com.pccw.lizhihui.cmcc.domain.User;
import com.pccw.lizhihui.cmcc.domain.repository.LoginRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by lizhihui on 3/16/16.
 *
 */
@Singleton
public class UserDataRepository implements LoginRepository{

    private final UserDataStoreFactory userDataStoreFactory ;

    private final UserEntityDataMapper userEntityDataMapper;

    @Inject
    public UserDataRepository(UserDataStoreFactory dataStoreFactory,
                              UserEntityDataMapper userEntityDataMapper){
        this.userDataStoreFactory = dataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;

    }

    @Override
    public Observable<User> user(String username, String password) {
        final UserDataStore userDataStore = this.userDataStoreFactory.create(username,password);
        return userDataStore.user(username,password).map(userEntity -> {
            return this.userEntityDataMapper.transform(userEntity);
        });
    }
}
