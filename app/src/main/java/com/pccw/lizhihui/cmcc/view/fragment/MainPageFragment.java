package com.pccw.lizhihui.cmcc.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.components.MainPageComponent;
import com.pccw.lizhihui.cmcc.presenter.MainPagePresenter;
import com.pccw.lizhihui.cmcc.view.MainPageView;
import com.pccw.lizhihui.cmcc.view.adapter.MainPagerAdapter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lizhihui on 3/29/16.
 *
 */
public class MainPageFragment extends BaseFragment implements MainPageView {

    public interface MainPageContainerListener {
        public void onPageSelected(int position);
    }

    @Bind(R.id.bottom_radio_group) RadioGroup rg_bottom;

    @Bind(R.id.vp_container) ViewPager viewPager;

    @Inject MainPagePresenter mainPagePresenter;

    @Inject MainPagerAdapter mainPagerAdapter;

    private MainPageContainerListener mainPageContainerListener;

    public MainPageFragment(){
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainPageContainerListener){
            this.mainPageContainerListener = (MainPageContainerListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(MainPageComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_main_page_container, container, false);
        ButterKnife.bind(this, fragmentView);
        this.setupViewPager();
        this.setupRadioGroup();
        return fragmentView;
    }

    private void setupRadioGroup() {
        this.rg_bottom.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private void setupViewPager() {
        this.viewPager.setAdapter(this.mainPagerAdapter);
        this.viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int index = group.indexOfChild(group.findViewById(checkedId));
            MainPageFragment.this.viewPager.setCurrentItem(index);
        }
    };

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            MainPageFragment.this.rg_bottom.check(MainPageFragment.this.rg_bottom.getChildAt(position).getId());
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onPageSelected(int position) {
        viewPager.setCurrentItem(position);
    }
}
