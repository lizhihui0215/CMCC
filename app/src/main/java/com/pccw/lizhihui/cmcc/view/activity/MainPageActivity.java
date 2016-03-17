package com.pccw.lizhihui.cmcc.view.activity;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;
import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.MainPageComponent;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainPageActivity extends BaseActivity implements HasComponent<MainPageComponent>{

    private static final int NUM_PAGES = 3;

    @Bind(R.id.bottom_radio_group) RadioGroup rg_bottom;

    @Bind(R.id.container_view_pager) ViewPager vp_container;

    private PagerAdapter pagerAdapter;

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, MainPageActivity.class);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);

        ButterKnife.bind(this);

        this.setupContainerView();
    }

    private void setupContainerView() {
        this.pagerAdapter = new ContainerPagerAdapter(getSupportFragmentManager());

        this.vp_container.setAdapter(this.pagerAdapter);
    }

    @Override
    public MainPageComponent getComponent() { return null; }

    private class ContainerPagerAdapter extends FragmentPagerAdapter{

        public ContainerPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return  MainPageFragmentFactory.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
