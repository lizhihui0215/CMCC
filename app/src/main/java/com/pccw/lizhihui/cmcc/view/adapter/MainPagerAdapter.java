package com.pccw.lizhihui.cmcc.view.adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pccw.lizhihui.cmcc.view.fragment.AssetFragment;
import com.pccw.lizhihui.cmcc.view.fragment.BaseFragment;
import com.pccw.lizhihui.cmcc.view.fragment.HomeFragment;
import com.pccw.lizhihui.cmcc.view.fragment.MineFragment;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by lizhihui on 3/24/16.
 *
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    @Inject
    public MainPagerAdapter(FragmentManager fm,
                            HomeFragment homeFragment,
                            AssetFragment assetFragment,
                            MineFragment mineFragment) {
        super(fm);
        this.fragments = Arrays.asList(homeFragment, assetFragment, mineFragment);
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }
}
