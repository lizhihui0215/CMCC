package com.pccw.lizhihui.cmcc.internal.di.modules;

import android.content.Context;

import com.pccw.lizhihui.cmcc.AndroidApplication;
import com.pccw.lizhihui.cmcc.UIThread;
import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.cache.UserCacheImpl;
import com.pccw.lizhihui.cmcc.data.repository.UserDataRepository;
import com.pccw.lizhihui.cmcc.domain.executor.JobExecutor;
import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.UserRepository;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhihui on 3/16/16.
 * Dagger moudle that provides objects which will live during the application lifecycle
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;
    public ApplicationModule (AndroidApplication application){ this.application = application; }
    @Provides @Singleton Context provideApplicationContext(){ return this.application; }

    @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){ return jobExecutor; }

    @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
        return userCache;
    }

    @Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }}