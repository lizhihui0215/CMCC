package com.pccw.lizhihui.cmcc.presenter;

import android.support.annotation.NonNull;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.view.MainPageView;

import javax.inject.Inject;

/**
 * Created by lizhihui on 3/29/16.
 *
 */
@PerActivity
public class MainPagePresenter implements Presenter {

    private MainPageView mainPageView;

    @Inject
    public MainPagePresenter(){

    }

    public void setView(@NonNull MainPageView mainPageView){
        this.mainPageView = mainPageView;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {}

    public void onPageSelected(int position) {

    }
}
