package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lizhihui on 3/31/16.
 *
 */
public class GetTaskNumber extends HomeCase {

    private final HomeRepository homeRepository;

    @Inject
    public GetTaskNumber(HomeRepository homeRepository){
        this.homeRepository = homeRepository;
    }

    @Override
    protected Observable buildHomeCaseObservable() {
        return this.homeRepository.taskNumber();
    }
}
