package com.pccw.lizhihui.cmcc.data.repository.main.datasource;

import com.pccw.lizhihui.cmcc.domain.LaunchOption;

import rx.Observable;

/**
 * Created by lizhihui on 4/17/16.
 */
public interface LaunchOptionStore {
    Observable<LaunchOption> launchOption();
}
