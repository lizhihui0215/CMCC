package com.pccw.lizhihui.cmcc.internal.di.components;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.net.NetworkReachbaliltyManager;
import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;
import com.pccw.lizhihui.cmcc.domain.repository.LaunchRepository;
import com.pccw.lizhihui.cmcc.domain.repository.LoginRepository;
import com.pccw.lizhihui.cmcc.internal.di.modules.ApplicationModule;
import com.pccw.lizhihui.cmcc.view.activity.BaseActivity;
import com.pccw.lizhihui.cmcc.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lizhihui on 3/16/16.
 * A component whose lifetime is the life of the application
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    void inject(MainActivity mainActivity);
    //Exposed to sub-graphs
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutorThread();
    HomeRepository homeRepository();
    LoginRepository loginRepository();
}
