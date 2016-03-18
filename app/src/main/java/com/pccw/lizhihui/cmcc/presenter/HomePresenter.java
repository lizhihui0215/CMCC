package com.pccw.lizhihui.cmcc.presenter;

import android.support.annotation.NonNull;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.view.HomeDetailsView;

/**
 * Created by lizhihui on 3/18/16.
 *
 */
@PerActivity
public class HomePresenter implements Presenter {

    private HomeDetailsView homeDetailsView;

    public void setView(@NonNull HomeDetailsView view){ this.homeDetailsView = view; }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
