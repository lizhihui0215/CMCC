package com.pccw.lizhihui.cmcc.data.repository.main.datasource;

import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.net.NetworkServices;
import com.pccw.lizhihui.cmcc.domain.LaunchOption;
import rx.Observable;

/**
 * Created by lizhihui on 4/17/16.
 *
 */
public class OnlineLaunchOptionStore implements LaunchOptionStore {
    private final UserCache userCache;

    private final NetworkServices networkServices;

    private Observable<LaunchOption> launchOptionToLogin = Observable.create(subscriber -> {
        subscriber.onNext(LaunchOption.LAUNCH_OPTION_FROM_LOGIN);
        subscriber.onCompleted();
    });

    private Observable<LaunchOption> launchOptionToMain = Observable.create(subscriber -> {
        subscriber.onNext(LaunchOption.LAUNCH_OPTION_FROM_MAIN);
        subscriber.onCompleted();
    });

    public OnlineLaunchOptionStore(UserCache userCache, NetworkServices networkServices) {
        this.userCache = userCache;
        this.networkServices = networkServices;
    }

    @Override
    public Observable<LaunchOption> launchOption() {
        return this.userCache.get()
                .switchMap(userEntity -> {
                    Observable<LaunchOption> launchOptionObservable = null;
                    if (userEntity != null){
                        launchOptionObservable = OnlineLaunchOptionStore.this.networkServices
                                .fetchAccessToken(userEntity.getAccessToken())
                                .switchMap(accessToken -> {
                                    if (null != accessToken){
                                        userEntity.setAccessToken(accessToken);
                                        try {
                                            OnlineLaunchOptionStore.this.userCache.put(userEntity);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        return launchOptionToMain;
                                    }else {
                                        return launchOptionToLogin;
                                    }
                                })
                                .onErrorResumeNext(throwable -> launchOptionToLogin);
                    }else {
                        launchOptionObservable = launchOptionToLogin;
                    }
                    return launchOptionObservable;
                });
    }
}
