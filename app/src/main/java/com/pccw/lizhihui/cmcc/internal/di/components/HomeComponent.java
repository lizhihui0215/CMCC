package com.pccw.lizhihui.cmcc.internal.di.components;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityModule;
import com.pccw.lizhihui.cmcc.view.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by lizhihui on 3/18/16.
 *
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface HomeComponent extends ActivityComponent{
    void inject(HomeFragment homeFragment);
}
