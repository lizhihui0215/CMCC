package com.pccw.lizhihui.cmcc.view.fragment;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.github.kevinsawicki.wishlist.ViewUtils;
import com.pccw.lizhihui.cmcc.R;

/**
 * Created by lizhihui on 4/28/16.
 *
 */
public abstract class TabPagerFragment<V extends PagerAdapter & FragmentProvider>
    extends PageFragment implements TabHost.OnTabChangeListener, TabHost.TabContentFactory{

    /** View pager */
    protected ViewPager pager;

    /** Tab host */
    protected TabLayout tabLayout;

    /** Pager adapter */

    protected V adapter;


    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
    }

    @Override
    public void onTabChanged(String tabId) {

    }

    @Override
    public View createTabContent(String tag) {
        return ViewUtils.setGone(new View(getActivity().getApplication()),true);
    }

    /**
     * Create pager adapter
     *
     * @return pager adapter
     */
    protected abstract V createAdapter();


    /**
     * Get title for position
     *
     * @param position
     * @return title
     */
    protected String getTitle(final  int position){
        return this.adapter.getPageTitle(position).toString();
    }

    /**
     * Get icon for position
     *
     * @param position
     * @return icon
     */
    protected @DrawableRes int getIcon(int position){
        return this.adapter.getIcon(position);
    }


    /**
     * Set tab and pager as gone or visible
     *
     * @param gone
     * @return this activity
     */
    protected TabPagerFragment<V> setGone(boolean gone){
        ViewUtils.setGone(this.tabLayout,gone);
        ViewUtils.setGone(this.pager, gone);
        return this;
    }

    /**
     * Set current item to new position
     * <p/>
     * This is guaranteed to only be called when a position changes and the
     * current item of the pager has already been updated to the given position
     * <p/>
     * Sub-classes may override this method
     *
     * @param position
     */
    protected void setCurrentItem(final int position){

    }

    /**
     * Get content view to be used when {@link #onCreate(android.os.Bundle)} is called
     *
     * @return layout resource id
     */
    protected int getContentView(){
        return R.layout.pager_with_tabs;
    }

    private void createPager(){
        this.adapter = createAdapter();
        this.getActivity().supportInvalidateOptionsMenu();
        this.pager.setAdapter(adapter);
        this.tabLayout.setupWithViewPager(this.pager);
        this.setTabIcons();
    }

    private void setTabIcons() {
        int tabCount = this.tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            int icon = this.getIcon(i);
            this.tabLayout.getTabAt(i).setIcon(icon);
        }
    }

    /**
     * Configure tabs and pager
     */
    protected void configureTabPager() {
        createPager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentView(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        view.findViewById(R.id.toolbar).setVisibility(View.GONE);

        // On Lollipop, the action bar shadow is provided by default, so have to remove it explicitly
        ((AppCompatActivity) getActivity()).getSupportActionBar().setElevation(0);

        this.pager = (ViewPager) view.findViewById(R.id.vp_pages);
        this.pager.addOnPageChangeListener(this);
        this.tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs_layout);
    }

    @Override
    protected FragmentProvider getProvider() {
        return this.adapter;
    }
}
