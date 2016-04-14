package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.net.NetworkServices;
import com.pccw.lizhihui.cmcc.data.net.NetworkServicesImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lizhihui on 4/1/16.
 */
@Singleton
public class UserDataStoreFactory {
    private final UserCache userCache;
    private Context context;

    @Inject
    public UserDataStoreFactory(Context context, UserCache userCache){
        if (context == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context;

        this.userCache = userCache;
    }

    public UserDataStore create(String username, String password){
        UserDataStore dataStore;
        if (false){
            dataStore = new DiskUserDataStore();
        }else {
            dataStore = createCloudDataStore();
        }

        return dataStore;
    }

    private UserDataStore createCloudDataStore() {

        NetworkServices networkServices = new NetworkServicesImpl(this.context);


        return new CloudUserDataStore(networkServices,this.userCache);
    }

}
