package com.pccw.lizhihui.cmcc.internal.di.components;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityMoudle;
import com.pccw.lizhihui.cmcc.view.fragment.AssetManagerFragment;
import com.pccw.lizhihui.cmcc.view.fragment.MineFragment;

import dagger.Component;

/**
 * Created by lizhihui on 3/17/16.
 *
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityMoudle.class})
public interface MainPageComponent {
    void inject(HomeFragment homeFragment);
    void inject(AssetManagerFragment assetManagerFragment);
    void inject(MineFragment mineFragment);
}
