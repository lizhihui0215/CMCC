package com.pccw.lizhihui.cmcc;


import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;

import javax.inject.Inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by lizhihui on 3/16/16.
 *
 */
public class UIThread implements PostExecutionThread{
    @Inject
    public UIThread(){}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
