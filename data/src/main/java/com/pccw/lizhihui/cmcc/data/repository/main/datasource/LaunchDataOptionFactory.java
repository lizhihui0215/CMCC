package com.pccw.lizhihui.cmcc.data.repository.main.datasource;


import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.net.NetworkReachbaliltyManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lizhihui on 4/17/16.
 *
 */
@Singleton
public class LaunchDataOptionFactory {

    private final NetworkReachbaliltyManager networkReachbaliltyManager;
    private final UserCache userCache;

    @Inject
    public LaunchDataOptionFactory(NetworkReachbaliltyManager networkReachbaliltyManager, UserCache userCache){
        this.networkReachbaliltyManager = networkReachbaliltyManager;
        this.userCache = userCache;
    }

    public LaunchOptionStore create() {

        LaunchOptionStore launchOptionStore = null;
        if(false
                //this.networkReachbaliltyManager.isThereInternetConnection()
        ){
            launchOptionStore = new OnlineLaunchOptionStore();
        }else {
            launchOptionStore = new OfflineLaunchDataStore(this.userCache);
        }

        return launchOptionStore;
    }
}
