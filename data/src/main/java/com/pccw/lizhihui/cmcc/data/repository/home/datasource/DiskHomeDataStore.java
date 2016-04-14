package com.pccw.lizhihui.cmcc.data.repository.home.datasource;

import com.pccw.lizhihui.cmcc.data.R;
import com.pccw.lizhihui.cmcc.data.entity.HomeEntity;
import com.pccw.lizhihui.cmcc.domain.Province;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class DiskHomeDataStore implements HomeDataStore {


    public DiskHomeDataStore() {

    }

    @Override
    public Observable<List<HomeEntity>> homeEntityList(Province province) {
        return Observable.create(subscriber -> {
            if (true) {
                try {
                    subscriber.onNext(this.homeListItems(province));
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(new Exception("test"));
                }
            } else {
                subscriber.onError(new Exception("test"));
            }
        });
    }

    @Override
    public Observable<Integer> homeTaskNumber() {
        return Observable.create(subscriber -> {
            subscriber.onNext(new Integer("3"));
            subscriber.onCompleted();
        });
    }


    private List<HomeEntity> homeListItems(Province province){
        HomeEntity homeEntity = new HomeEntity(R.drawable.my_task_01,"在建工程专资");

        HomeEntity homeEntity2 = new HomeEntity(R.drawable.my_task_02,"零购新增资产");

        HomeEntity homeEntity3 = new HomeEntity(R.drawable.my_task_03,"盘点");

        HomeEntity homeEntity4 = new HomeEntity(R.drawable.my_task_04,"部门内调拨");

        HomeEntity homeEntity5 = new HomeEntity(R.drawable.my_task_05, "部门间调拨");

        HomeEntity homeEntity6 = new HomeEntity(R.drawable.my_task_06, "地市间调拨");

        HomeEntity homeEntity7 = new HomeEntity(R.drawable.my_task_07, "巡检");

        HomeEntity homeEntity8 = new HomeEntity(R.drawable.my_task_08, "地点信息修改");

        HomeEntity homeEntity9 = new HomeEntity(R.drawable.my_task_09, "通知");

        HomeEntity homeEntity10 = new HomeEntity(R.drawable.my_task_10, "基础数据");

        List<HomeEntity> homeEntities = new ArrayList<>();
        homeEntities.add(homeEntity);
        if (province != Province.ZHEJIANG) homeEntities.add(homeEntity2);
        homeEntities.add(homeEntity3);
        homeEntities.add(homeEntity4);
        homeEntities.add(homeEntity5);
        if (province != Province.ZHEJIANG) homeEntities.add(homeEntity6);
        homeEntities.add(homeEntity7);
        homeEntities.add(homeEntity8);
        homeEntities.add(homeEntity9);
        homeEntities.add(homeEntity10);

        return homeEntities;
    }
}
