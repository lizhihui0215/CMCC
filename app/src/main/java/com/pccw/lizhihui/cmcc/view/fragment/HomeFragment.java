package com.pccw.lizhihui.cmcc.view.fragment;

import android.content.Context;
import android.os.Bundle;

import com.pccw.lizhihui.cmcc.internal.di.components.HomeComponent;
import com.pccw.lizhihui.cmcc.presenter.HomePresenter;
import com.pccw.lizhihui.cmcc.view.HomeDetailsView;

import javax.inject.Inject;

/**
 * Created by lizhihui on 3/17/16.
 *
 */
public class HomeFragment extends BaseFragment implements HomeDetailsView {


    @Inject HomePresenter homePresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(HomeComponent.class).inject(this);
    }

    @Override
    public void showLoading() {}

    @Override
    public void hideLoading() {}

    @Override
    public void showRetry() {}

    @Override
    public void hidenRetry() {}

    @Override
    public void showError(String message) {}

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }
}
