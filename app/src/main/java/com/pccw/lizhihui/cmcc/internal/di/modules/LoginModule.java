package com.pccw.lizhihui.cmcc.internal.di.modules;

import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.interactor.LoginCase;
import com.pccw.lizhihui.cmcc.domain.interactor.LoginGetUser;
import com.pccw.lizhihui.cmcc.domain.repository.LoginRepository;
import com.pccw.lizhihui.cmcc.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
@Module
public class LoginModule {
    public LoginModule(){}

    @Provides @PerActivity @Named("login")
    LoginCase provideLoginUseCase(LoginRepository loginRepository,
                                  ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread){
        return new LoginGetUser(loginRepository,threadExecutor,postExecutionThread);
    }

}
