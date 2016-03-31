package com.pccw.lizhihui.cmcc.view;

import com.pccw.lizhihui.cmcc.model.HomeModel;

import java.util.Collection;

/**
 * Created by lizhihui on 3/30/16.
 */
public interface HomeView extends LoadDataView{

    void renderHomeList(Collection<HomeModel> homeModels);

    void renderMyTaskNumebr(Integer taskNumber);

}
