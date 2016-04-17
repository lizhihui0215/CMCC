package com.pccw.lizhihui.cmcc.data.repository.main.datasource;

import com.pccw.lizhihui.cmcc.data.cache.UserCache;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;
import com.pccw.lizhihui.cmcc.domain.LaunchOption;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by lizhihui on 4/17/16.
 */
public class OfflineLaunchDataStore implements LaunchOptionStore{

    private final UserCache userCache;

    public OfflineLaunchDataStore(UserCache userCache) {
        this.userCache = userCache;
    }


    @Override
    public Observable<LaunchOption> launchOption() {
        return this.userCache.get().concatMap((Func1<UserEntity, Observable<LaunchOption>>) userEntity -> Observable.create(subs->{

            if (userEntity == null)
                subs.onNext(LaunchOption.LAUNCH_OPTION_FROM_LOGIN);
            else
                subs.onNext(LaunchOption.LAUNCH_OPTION_FROM_MAIN);
            subs.onCompleted();
        }));
    }


}
