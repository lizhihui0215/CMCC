package com.pccw.lizhihui.cmcc.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

/**
 * Created by lizhihui on 4/28/16.
 *
 */
public class FragmentPagerAdapter extends
        android.support.v4.app.FragmentPagerAdapter implements FragmentProvider {

    private AppCompatActivity activity;

    private final FragmentManager fragmentManager;

    private final Set<String> tags = new HashSet<>();

    private int containerId;

    private Fragment selected;

    @Inject
    public FragmentPagerAdapter(FragmentManager fm, AppCompatActivity activity) {
        super(fm);
        this.activity = activity;
        this.fragmentManager = fm;
    }

    public boolean isEmpty() {
        return tags.isEmpty();
    }


    public FragmentPagerAdapter clearAdapter(){
        if (this.tags.isEmpty())
            return this;

        FragmentTransaction transaction = this.fragmentManager.beginTransaction();

        for (String tag : this.tags) {
            Fragment fragment = this.fragmentManager.findFragmentByTag(tag);
            if (fragment != null)
                transaction.remove(fragment);
        }

        transaction.commit();

        this.tags.clear();

        return this;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public Fragment getSelected() {
        return this.selected;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
