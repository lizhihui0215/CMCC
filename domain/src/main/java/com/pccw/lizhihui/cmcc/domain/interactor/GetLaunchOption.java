package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.LaunchRepository;
import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lizhihui on 4/16/16.
 */
public class GetLaunchOption extends UseCase{

    private final LaunchRepository launchRepository;

    @Inject
    protected GetLaunchOption(LaunchRepository launchRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.launchRepository = launchRepository;
    }

    @Override
    protected Observable buildUseCaseObservable(Object... args) {

        return null;
    }
}
