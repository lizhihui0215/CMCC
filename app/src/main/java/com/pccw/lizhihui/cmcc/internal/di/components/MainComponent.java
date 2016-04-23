package com.pccw.lizhihui.cmcc.internal.di.components;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityModule;
import com.pccw.lizhihui.cmcc.internal.di.modules.MainMoudle;
import com.pccw.lizhihui.cmcc.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by lizhihui on 4/16/16.
 *
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class, MainMoudle.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
