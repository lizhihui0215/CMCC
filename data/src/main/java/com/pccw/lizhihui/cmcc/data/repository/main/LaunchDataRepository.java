package com.pccw.lizhihui.cmcc.data.repository.main;

import com.pccw.lizhihui.cmcc.data.repository.main.datasource.LaunchDataOptionFactory;
import com.pccw.lizhihui.cmcc.data.repository.main.datasource.LaunchOptionStore;
import com.pccw.lizhihui.cmcc.domain.LaunchOption;
import com.pccw.lizhihui.cmcc.domain.repository.LaunchRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lizhihui on 4/17/16.
 */
public class LaunchDataRepository implements LaunchRepository {

    private final LaunchDataOptionFactory launchDataOptionFactory;


    @Inject
    public LaunchDataRepository(LaunchDataOptionFactory launchDataOptionFactory){
        this.launchDataOptionFactory = launchDataOptionFactory;
    }

    @Override
    public Observable<LaunchOption> launchOption() {
        final LaunchOptionStore launchOptionStore = this.launchDataOptionFactory.create();
        return launchOptionStore.launchOption();
    }
}
