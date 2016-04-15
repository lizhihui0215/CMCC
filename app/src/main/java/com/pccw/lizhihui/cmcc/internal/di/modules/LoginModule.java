package com.pccw.lizhihui.cmcc.internal.di.modules;

import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.interactor.UseCase;
import com.pccw.lizhihui.cmcc.domain.interactor.Login;
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
    UseCase provideLoginUseCase(LoginRepository loginRepository,
                                ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread){
        return new Login(loginRepository,threadExecutor,postExecutionThread);
    }

}
