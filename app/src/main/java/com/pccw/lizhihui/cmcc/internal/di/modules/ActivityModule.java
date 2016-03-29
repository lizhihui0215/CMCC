package com.pccw.lizhihui.cmcc.internal.di.modules;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhihui on 3/17/16.
 *
 * A moudle to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityModule {
    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity){ this.activity = activity; }

    @Provides @PerActivity FragmentManager fragmentManager(){
        return this.activity.getSupportFragmentManager();
    }

    @Provides @PerActivity AppCompatActivity activity(){ return this.activity; }

}
