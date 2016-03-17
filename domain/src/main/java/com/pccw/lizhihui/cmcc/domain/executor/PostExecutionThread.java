package com.pccw.lizhihui.cmcc.domain.executor;

import rx.Scheduler;

/**
 * Created by lizhihui on 3/16/16.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
