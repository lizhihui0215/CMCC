package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import android.util.Log;

import com.pccw.lizhihui.cmcc.data.entity.LoginParameters;
import com.pccw.lizhihui.cmcc.domain.User;
import com.pccw.lizhihui.cmcc.data.net.NetworkServices;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by lizhihui on 4/1/16.
 */
public class CloudUserDataStore implements UserDataStore {

    private final NetworkServices NetworkServices;

    private final Action1<LoginParameters> saveToCacheAction = userEntity -> {
        Log.v("save user" + userEntity,"login");
    };

    public CloudUserDataStore(NetworkServices NetworkServices) {
        this.NetworkServices = NetworkServices;
    }

    @Override
    public Observable<User> user(String username, String password) {
        return this.NetworkServices.userEntityBy(username,password);
    }
}
