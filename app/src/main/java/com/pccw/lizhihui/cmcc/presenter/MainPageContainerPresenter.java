package com.pccw.lizhihui.cmcc.presenter;

import android.support.annotation.NonNull;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.view.MainPageContainerView;

import javax.inject.Inject;

/**
 * Created by lizhihui on 3/29/16.
 *
 */
@PerActivity
public class MainPageContainerPresenter implements Presenter {

    private MainPageContainerView mainPageContainerView;

    @Inject
    public MainPageContainerPresenter(){

    }

    public void setView(@NonNull MainPageContainerView mainPageContainerView){
        this.mainPageContainerView = mainPageContainerView;
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
