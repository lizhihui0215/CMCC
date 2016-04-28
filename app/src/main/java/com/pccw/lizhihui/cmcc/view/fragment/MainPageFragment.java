package com.pccw.lizhihui.cmcc.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.pccw.lizhihui.cmcc.internal.di.components.MainPageComponent;
import com.pccw.lizhihui.cmcc.presenter.MainPagePresenter;
import com.pccw.lizhihui.cmcc.view.MainPageView;
import com.pccw.lizhihui.cmcc.view.adapter.MainPagerAdapter;

import javax.inject.Inject;

/**
 * Created by lizhihui on 3/29/16.
 *
 */
public class MainPageFragment extends TabPagerFragment<MainPagerAdapter> implements MainPageView {

    public interface MainPageContainerListener {
        public void onPageSelected(int position);
    }

    @Inject MainPagePresenter mainPagePresenter;

    @Inject MainPagerAdapter mainPagerAdapter;

    public MainPageFragment(){
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MainPageComponent.class).inject(this);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        this.configureTabPager();
    }


        @Override
    protected MainPagerAdapter createAdapter() {
        return this.mainPagerAdapter;
    }
}
