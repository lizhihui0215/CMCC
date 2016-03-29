package com.pccw.lizhihui.cmcc.internal.di.components;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityModule;
import com.pccw.lizhihui.cmcc.internal.di.modules.MainPageModule;
import com.pccw.lizhihui.cmcc.view.adapter.MainPagerAdapter;
import com.pccw.lizhihui.cmcc.view.fragment.MainPageFragment;

import dagger.Component;

/**
 * Created by lizhihui on 3/17/16.
 *
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,MainPageModule.class})
public interface MainPageComponent extends ActivityComponent{
    void inject(MainPageFragment mainPageFragment);
    void inject(MainPagerAdapter mainPagerAdapter);
}
