package com.pccw.lizhihui.cmcc.internal.di.modules;

import android.content.Context;

import com.pccw.lizhihui.cmcc.AndroidApplication;
import com.pccw.lizhihui.cmcc.UIThread;
import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.cache.UserCacheImpl;
import com.pccw.lizhihui.cmcc.data.database.Database;
import com.pccw.lizhihui.cmcc.data.database.DatabaseImpl;
import com.pccw.lizhihui.cmcc.data.repository.home.HomeDataRepository;
import com.pccw.lizhihui.cmcc.data.repository.login.UserDataRepository;
import com.pccw.lizhihui.cmcc.domain.executor.JobExecutor;
import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;
import com.pccw.lizhihui.cmcc.domain.repository.LoginRepository;

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

    public ApplicationModule (AndroidApplication application){
        this.application = application;
    }

    @Provides @Singleton Context provideApplicationContext(){ return this.application; }

    @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){ return jobExecutor; }

    @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
        return userCache;
    }

    @Provides @Singleton HomeRepository provideHomeRepository(HomeDataRepository homeDataRepository){
        return homeDataRepository;
    }

    @Provides @Singleton LoginRepository provideLoginRepository(UserDataRepository userDataRepository){
        return userDataRepository;
    }

    @Provides @Singleton Database provideDatabase(DatabaseImpl database){
        return database;
    }



}
