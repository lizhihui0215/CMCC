package com.pccw.lizhihui.cmcc.navigation;
import android.content.Context;
import android.content.Intent;

import com.pccw.lizhihui.cmcc.view.activity.LoginActivity;
import com.pccw.lizhihui.cmcc.view.activity.ContainerActivity;

import javax.inject.Inject;
import javax.inject.Singleton;
/**
 * Created by lizhihui on 3/16/16.
 *
 */
@Singleton
public class Navigator {
    @Inject
    public Navigator(){
        //empty
    }

    public void navigateToLogin(Context context){
        if (null != context){
            Intent intentToLaunch = LoginActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }


    public void navigateToMainPage(Context context) {
        if (null != context){
            Intent intentToLaunch = ContainerActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

}
