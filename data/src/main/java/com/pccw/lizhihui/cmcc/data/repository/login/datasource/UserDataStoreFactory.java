package com.pccw.lizhihui.cmcc.data.repository.login.datasource;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.database.Database;
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

    private final NetworkServices networkServices;

    private Context context;

    private final Database database;

    @Inject
    public UserDataStoreFactory(Context context, UserCache userCache, Database database, NetworkServices networkServices){
        if (context == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context;

        this.userCache = userCache;

        this.database = database;

        this.networkServices = networkServices;
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

        return new CloudUserDataStore(this.networkServices,this.userCache, this.database);
    }

}
