package com.pccw.lizhihui.cmcc.data.repository.home;

import com.pccw.lizhihui.cmcc.data.entity.mapper.HomeEntityDataMapper;
import com.pccw.lizhihui.cmcc.data.repository.home.datasource.HomeDataStore;
import com.pccw.lizhihui.cmcc.data.repository.home.datasource.HomeDataStoreFactory;
import com.pccw.lizhihui.cmcc.domain.HomeItem;
import com.pccw.lizhihui.cmcc.domain.Province;
import com.pccw.lizhihui.cmcc.domain.repository.HomeRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
@Singleton
public class HomeDataRepository implements HomeRepository {

    private final HomeDataStoreFactory homeDataStoreFactory;

    private final HomeEntityDataMapper homeEntityDataMapper;

    @Inject
    public HomeDataRepository(HomeDataStoreFactory homeDataStoreFactory,
                              HomeEntityDataMapper homeEntityDataMapper){
        this.homeDataStoreFactory = homeDataStoreFactory;
        this.homeEntityDataMapper = homeEntityDataMapper;
    }


    @Override
    @SuppressWarnings("Convert2MethodRef")
    public Observable<List<HomeItem>> items(Province province) {
        final HomeDataStore homeDataStore = this.homeDataStoreFactory.create();

        return homeDataStore.homeEntityList(province)
                .map(homeEntities ->{
                    return this.homeEntityDataMapper.transform(homeEntities);
                });
    }

    @Override
    public Observable<Integer> taskNumber() {
        final HomeDataStore homeDataStore = this.homeDataStoreFactory.create();

        return homeDataStore.homeTaskNumber();
    }
}
