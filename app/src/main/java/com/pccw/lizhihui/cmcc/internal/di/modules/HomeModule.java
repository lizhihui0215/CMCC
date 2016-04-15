package com.pccw.lizhihui.cmcc.internal.di.modules;

import com.pccw.lizhihui.cmcc.domain.Province;
import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.interactor.GetHomeList;
import com.pccw.lizhihui.cmcc.domain.interactor.GetTaskNumber;
import com.pccw.lizhihui.cmcc.domain.interactor.UseCase;
import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;
import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhihui on 3/31/16.
 *
 */
@Module
public class HomeModule {
    private Province province = Province.UNKNOW;

    public HomeModule(Province province){
        this.province = province;
    }

    @Provides @PerActivity @Named("homeList") UseCase provideGetHomeListUseCase(HomeRepository homeRepository, ThreadExecutor threadExecutor,
                                                                                PostExecutionThread postExecutionThread){
        return new GetHomeList(this.province,homeRepository,threadExecutor,postExecutionThread);
    }

    @Provides @PerActivity @Named("homeTaskNumber") UseCase provideGetHomeNumberUseCase(GetTaskNumber getTaskNumber){
        return getTaskNumber;
    }
}
