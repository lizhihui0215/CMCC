package com.pccw.lizhihui.cmcc.data.repository.datasource;

import android.util.Log;

import com.pccw.lizhihui.cmcc.data.entity.UserEntity;
import com.pccw.lizhihui.cmcc.data.net.RestAPI;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by lizhihui on 4/1/16.
 */
public class CloudUserDataStore implements UserDataStore {

    private final RestAPI restAPI;

    private final Action1<UserEntity> saveToCacheAction = userEntity -> {
        Log.v("save user" + userEntity,"login");
    };

    public CloudUserDataStore(RestAPI restAPI) {
        this.restAPI = restAPI;
    }

    @Override
    public Observable<UserEntity> user(String username, String password) {
        return this.restAPI.userEntityBy(username,password);
    }
}
