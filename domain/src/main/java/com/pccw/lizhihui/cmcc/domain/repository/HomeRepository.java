package com.pccw.lizhihui.cmcc.domain.repository;

import com.pccw.lizhihui.cmcc.domain.HomeItem;
import com.pccw.lizhihui.cmcc.domain.Province;

import java.util.List;

import rx.Observable;

/**
 * Created by lizhihui on 3/30/16.
 */
public interface HomeRepository {
    Observable<List<HomeItem>> items(Province proviceId);

    Observable<Integer> taskNumber();
}
