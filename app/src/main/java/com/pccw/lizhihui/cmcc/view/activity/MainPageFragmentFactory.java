package com.pccw.lizhihui.cmcc.view.activity;

import android.support.v4.app.Fragment;

import com.pccw.lizhihui.cmcc.view.fragment.AssetFragment;
import com.pccw.lizhihui.cmcc.view.fragment.HomeFragment;
import com.pccw.lizhihui.cmcc.view.fragment.MineFragment;

/**
 * Created by lizhihui on 3/17/16.
 *
 */
public class MainPageFragmentFactory {
    public static Fragment create(int pageNumber){
        Fragment fragment = null;
        switch (pageNumber){
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new AssetFragment();
                break;
            case 2:
                fragment = new MineFragment();
                break;
        }
        return fragment;
    }

}
