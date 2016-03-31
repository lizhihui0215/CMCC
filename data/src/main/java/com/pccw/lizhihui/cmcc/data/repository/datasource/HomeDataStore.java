package com.pccw.lizhihui.cmcc.data.repository.datasource;


import com.pccw.lizhihui.cmcc.data.entity.HomeEntity;
import com.pccw.lizhihui.cmcc.domain.Province;

import java.util.List;

import rx.Observable;

/**
 * Created by lizhihui on 3/30/16.
 */
public interface HomeDataStore {

    Observable<List<HomeEntity>> homeEntityList(Province province);

    Observable<Integer> homeTaskNumber();

}
