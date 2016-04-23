package com.pccw.lizhihui.cmcc.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by lizhihui on 4/17/16.
 *
 */
@Singleton
public class NetworkReachbaliltyManagerImpl implements NetworkReachbalityManager{

    private final Context context;

    @Inject
    public NetworkReachbaliltyManagerImpl(Context context){
        this.context = context;
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    @Override
    public boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
