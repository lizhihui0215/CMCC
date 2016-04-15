package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lizhihui on 3/31/16.
 *
 */
public class GetTaskNumber extends UseCase {

    private final HomeRepository homeRepository;

    @Inject
    public GetTaskNumber(HomeRepository homeRepository,
                         ThreadExecutor threadExecutor,
                         PostExecutionThread postExecutionThread){
        super(threadExecutor,postExecutionThread);

        this.homeRepository = homeRepository;
    }

    @Override
    protected Observable buildUseCaseObservable(Object ...args) {
        return this.homeRepository.taskNumber();
    }
}
