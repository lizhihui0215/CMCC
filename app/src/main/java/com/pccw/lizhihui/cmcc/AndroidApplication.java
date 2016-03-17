package com.pccw.lizhihui.cmcc;

import android.app.Application;

import com.pccw.lizhihui.cmcc.internal.di.components.ApplicationComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.DaggerApplicationComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by lizhihui on 3/16/16.
 *
 */
public class AndroidApplication extends Application{
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeLeakDetection() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void initializeInjector() {
        if (BuildConfig.DEBUG){
            LeakCanary.install(this);
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
