package com.pccw.lizhihui.cmcc.internal.di.components;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityModule;
import com.pccw.lizhihui.cmcc.internal.di.modules.MainMoudle;
import com.pccw.lizhihui.cmcc.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lizhihui on 4/16/16.
 *
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, MainMoudle.class})
public interface MainComponent {
}
