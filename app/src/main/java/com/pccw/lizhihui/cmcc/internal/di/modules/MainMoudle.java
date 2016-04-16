package com.pccw.lizhihui.cmcc.internal.di.modules;

import com.pccw.lizhihui.cmcc.domain.interactor.GetLaunchOption;
import com.pccw.lizhihui.cmcc.domain.interactor.UseCase;
import com.pccw.lizhihui.cmcc.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhihui on 4/17/16.
 */
@Module
public class MainMoudle {
    public MainMoudle(){}

    @Provides @PerActivity @Named("launchOption") UseCase provideLaunchOptionUseCase(GetLaunchOption getLaunchOption) {
        return getLaunchOption;
    }

}
