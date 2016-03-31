package com.pccw.lizhihui.cmcc.mapper;

import com.pccw.lizhihui.cmcc.domain.HomeItem;
import com.pccw.lizhihui.cmcc.model.HomeModel;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by lizhihui on 3/31/16.
 *
 */
public class HomeModelDataMapper {
    @Inject
    public HomeModelDataMapper(){}

    public HomeModel transform(HomeItem homeItem){
        if (homeItem == null){
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        HomeModel homeModel = new HomeModel();
        homeModel.setResid(homeItem.getId());
        homeModel.setTitle(homeItem.getTitle());
        return  homeModel;
    }

    public Collection<HomeModel> transform(Collection<HomeItem> homeItemCollection) {
        Collection<HomeModel> homeModelCollection = new ArrayList<>();;

        if (homeItemCollection != null && !homeItemCollection.isEmpty()){
            for (HomeItem homeItem : homeItemCollection) {
                homeModelCollection.add(transform(homeItem));
            }
        }

        return homeModelCollection;
    }
}
