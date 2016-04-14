package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.net.NetworkServices;
import com.pccw.lizhihui.cmcc.domain.User;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by lizhihui on 4/1/16.
 */
public class CloudUserDataStore implements UserDataStore {

    private final NetworkServices networkServices;

    private final UserCache userCache;



    private final Action1<User> saveToCacheAction = user -> {
        if (user != null){
            try {
                CloudUserDataStore.this.userCache.put(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            CloudUserDataStore.this.networkServices.setLoginUser(user);
        }
    };

    public CloudUserDataStore(NetworkServices NetworkServices,UserCache userCache) {
        this.networkServices = NetworkServices;
        this.userCache = userCache;
    }

    @Override
    public Observable<User> user(String username, String password) {
        return this.networkServices.userEntityBy(username,password).doOnNext(saveToCacheAction);
    }
}
