package com.pccw.lizhihui.cmcc.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

/**
 * Created by lizhihui on 4/28/16.
 *
 */
public abstract class FragmentPagerAdapter extends
        android.support.v4.app.FragmentPagerAdapter implements FragmentProvider {

    private AppCompatActivity activity;

    private final FragmentManager fragmentManager;

    private final Set<String> tags = new HashSet<>();

    private int containerId;

    private Fragment selected;

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
    public Object instantiateItem(ViewGroup container, int position) {

        Object fragment =  super.instantiateItem(container, position);

        this.containerId = container.getId();

        if (fragment instanceof Fragment){
            tags.add(((Fragment)fragment).getTag());
        }

        return fragment;
    }

    @Override
    public Fragment getSelected() {
        return this.selected;
    }

    public Fragment getFragmentByPosition(int fragmentPosition){
        String fragmentTag = getFragmentTag(this.containerId,fragmentPosition);

        return this.fragmentManager.findFragmentByTag(fragmentTag);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);

        boolean changed = false;

        if (object instanceof Fragment){
            changed = object != this.selected;
            this.selected = (Fragment) object;
        }else {
            changed = object != null;
            this.selected = null;
        }

        if (changed)
            this.activity.invalidateOptionsMenu();
    }

    private String getFragmentTag(int viewPagerId, int fragmentPosition) {
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }

}
