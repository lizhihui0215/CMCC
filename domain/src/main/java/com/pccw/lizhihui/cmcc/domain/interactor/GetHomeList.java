package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.Province;
import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class GetHomeList extends UseCase {
    private final Province proviceId;

    private final HomeRepository homeRepository;

    @Inject
    public GetHomeList(Province proviceId,
                       HomeRepository homeRepository,
                       ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);

        this.homeRepository = homeRepository;

        this.proviceId = proviceId;
    }


    @Override
    protected Observable buildUseCaseObservable(Object ... args) {
        return this.homeRepository.items(this.proviceId);
    }
}
