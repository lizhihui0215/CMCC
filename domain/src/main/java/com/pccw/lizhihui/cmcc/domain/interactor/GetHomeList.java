package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.Province;
import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class GetHomeList extends HomeCase {
    private final Province proviceId;

    private final HomeRepository homeRepository;

    @Inject
    public GetHomeList(Province proviceId, HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
        this.proviceId = proviceId;
    }

    @Override
    protected Observable buildHomeCaseObservable() {
        return this.homeRepository.items(this.proviceId);
    }
}
