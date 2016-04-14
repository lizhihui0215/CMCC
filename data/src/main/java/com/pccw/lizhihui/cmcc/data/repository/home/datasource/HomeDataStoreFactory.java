package com.pccw.lizhihui.cmcc.data.repository.home.datasource;

import android.content.Context;


import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
@Singleton
public class HomeDataStoreFactory {

    private final Context context;

    @Inject
    public HomeDataStoreFactory(Context context){
        if (context == null){
            throw  new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
    }

    public HomeDataStore create(){
        // only local
        HomeDataStore homeDataStore = new DiskHomeDataStore();
        return homeDataStore;
    }

}
