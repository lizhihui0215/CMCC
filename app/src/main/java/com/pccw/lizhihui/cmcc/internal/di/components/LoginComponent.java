package com.pccw.lizhihui.cmcc.internal.di.components;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityModule;
import com.pccw.lizhihui.cmcc.internal.di.modules.LoginModule;
import com.pccw.lizhihui.cmcc.view.fragment.LoginFragment;
import dagger.Component;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class,LoginModule.class})
public interface LoginComponent extends ActivityComponent{
    void inject(LoginFragment loginFragment);
}
