package com.pccw.lizhihui.cmcc.internal.di.modules;

import com.pccw.lizhihui.cmcc.domain.LaunchOption;
import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.interactor.GetLaunchOption;
import com.pccw.lizhihui.cmcc.domain.interactor.UseCase;
import com.pccw.lizhihui.cmcc.domain.repository.LaunchRepository;
import com.pccw.lizhihui.cmcc.internal.di.PerActivity;

import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhihui on 4/17/16.
 */
@Module
public class MainMoudle {
    public MainMoudle(){}

    @Provides @PerActivity @Named("GetLaunchOption")
    UseCase provideLaunchOptionUseCase(LaunchRepository launchRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {

        return new GetLaunchOption(launchRepository,threadExecutor,postExecutionThread);
    }
}
