package com.pccw.lizhihui.cmcc.data.repository.datasource;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.cache.HomeCache;
import com.pccw.lizhihui.cmcc.domain.Province;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
@Singleton
public class HomeDataStoreFactory {

    private final Context context;
    private final HomeCache homeCache;

    @Inject
    public HomeDataStoreFactory(Context context, HomeCache homeCache){
        if (context == null || homeCache == null){
            throw  new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.homeCache = homeCache;
    }

    public HomeDataStore create(){
        // only local
        HomeDataStore homeDataStore = new DiskHomeDataStore(this.homeCache);
        return homeDataStore;
    }

}
