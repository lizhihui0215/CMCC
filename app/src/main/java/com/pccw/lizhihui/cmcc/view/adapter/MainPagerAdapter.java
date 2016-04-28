package com.pccw.lizhihui.cmcc.view.adapter;


import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.view.fragment.AssetFragment;
import com.pccw.lizhihui.cmcc.view.fragment.BaseFragment;
import com.pccw.lizhihui.cmcc.view.fragment.FragmentPagerAdapter;
import com.pccw.lizhihui.cmcc.view.fragment.HomeFragment;
import com.pccw.lizhihui.cmcc.view.fragment.MineFragment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

/**
 * Created by lizhihui on 3/24/16.
 *
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    private final Resources resources;

    private final Set<String> tags = new HashSet<>();

    @Inject
    public MainPagerAdapter(FragmentManager fm,
                            AppCompatActivity activity,
                            HomeFragment homeFragment,
                            AssetFragment assetFragment,
                            MineFragment mineFragment) {
        super(fm,activity);
        this.fragments = Arrays.asList(homeFragment, assetFragment, mineFragment);
        resources = fm.getFragments().get(0).getResources();
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        if (fragment instanceof Fragment)
            this.tags.add(((Fragment) fragment).getTag());
        return fragment;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return resources.getString(R.string.tab_home);
            case 1:
                return resources.getString(R.string.tab_asset);
            case 2:
                return resources.getString(R.string.tab_mine);
            default:
                return null;
        }
    }

}
