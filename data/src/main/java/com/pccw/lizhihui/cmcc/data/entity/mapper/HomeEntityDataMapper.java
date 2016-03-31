package com.pccw.lizhihui.cmcc.data.entity.mapper;

import com.pccw.lizhihui.cmcc.data.entity.HomeEntity;
import com.pccw.lizhihui.cmcc.domain.HomeItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class HomeEntityDataMapper {

    @Inject
    public HomeEntityDataMapper(){}

    public HomeItem transform(HomeEntity homeEntity){
        HomeItem homeItem = new HomeItem();

        if (homeEntity != null){
            homeItem.setId(homeEntity.getResId());
            homeItem.setTitle(homeEntity.getName());
        }

        return homeItem;
    }

    public List<HomeItem> transform(List<HomeEntity> homeEntities) {
        List<HomeItem> homeItems = new ArrayList<>();

        for (HomeEntity homeEntity : homeEntities) {
            HomeItem homeItem = transform(homeEntity);
            if (homeItem != null){
                homeItems.add(homeItem);
            }
        }
        return homeItems;
    }
}
