package com.pccw.lizhihui.cmcc.data.repository.main.datasource;


import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.net.NetworkReachbalityManager;
import com.pccw.lizhihui.cmcc.data.net.NetworkServices;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lizhihui on 4/17/16.
 *
 */
@Singleton
public class LaunchDataOptionFactory {

    private final NetworkReachbalityManager networkReachbalityManager;

    private final UserCache userCache;

    private final NetworkServices networkServices;

    @Inject
    public LaunchDataOptionFactory(UserCache userCache, NetworkReachbalityManager networkReachbalityManager, NetworkServices networkServices){
        this.userCache = userCache;

        this.networkReachbalityManager = networkReachbalityManager;

        this.networkServices = networkServices;
    }

    public LaunchOptionStore create() {

        LaunchOptionStore launchOptionStore;
        if(this.networkReachbalityManager.isThereInternetConnection()){
            launchOptionStore = new OnlineLaunchOptionStore(this.userCache, this.networkServices);
        }else {
            launchOptionStore = new OfflineLaunchDataStore(this.userCache);
        }

        return launchOptionStore;
    }
}
