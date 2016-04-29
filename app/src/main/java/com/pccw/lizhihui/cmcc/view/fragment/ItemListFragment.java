package com.pccw.lizhihui.cmcc.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.kevinsawicki.wishlist.SingleTypeAdapter;
import com.github.kevinsawicki.wishlist.ViewUtils;
import com.pccw.lizhihui.cmcc.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by lizhihui on 4/29/16.
 *
 * Base fragment for displaying a list of items that loads with a progress bar visible
 *
 */
public abstract class ItemListFragment<E> extends BaseFragment implements
        LoaderManager.LoaderCallbacks<List<E>>, SwipeRefreshLayout.OnRefreshListener{

    private static final String FORCE_REFRESH = "forceRefresh";

    private SwipeRefreshLayout swipeLayout;

    /**
     * @param args
     *            bundle passed to the loader by the LoaderManager
     * @return true if the bundle indicates a requested forced refresh of the
     *         items
     */
    protected static boolean isForceRefresh(Bundle args){
        return args != null && args.getBoolean(FORCE_REFRESH, false);
    }

    /**
     * List items provided to {@link #onLoadFinished(Loader, List)}
     */
    protected List<E> items = Collections.emptyList();

    /**
     * List view
     */
    protected ListView listView;

    /**
     * Empty view
     */
    protected TextView emptyView;

    /**
     * Progress bar
     */
    protected ProgressBar progressBar;

    /**
     * Is the list currently shown
     */
    protected boolean listShown;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (!items.isEmpty()) this.setListShown(true,false);

        this.getLoaderManager().initLoader(0,null,this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        this.listShown = false;
        this.emptyView = null;
        this.progressBar = null;
        this.listView = null;

        super.onDestroy();
    }

    @Override
    public void onRefresh() {
        this.forceRefresh();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_item);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeResources(
                R.color.pager_title_background_top_start,
                R.color.pager_title_background_end,
                R.color.text_link,
                R.color.pager_title_background_end);

        listView = (ListView) view.findViewById(android.R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                onListItemClick((ListView) parent, view, position, id);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                return onListItemLongClick((ListView) parent, view, position,
                        id);
            }
        });
        progressBar = (ProgressBar) view.findViewById(R.id.pb_loading);

        emptyView = (TextView) view.findViewById(android.R.id.empty);

        this.configureList(getActivity(), getListView());
    }

    protected void configureList(FragmentActivity activity, ListView listView) {
        this.listView.setAdapter(this.createAdapter());
    }


    protected void forceRefresh() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(FORCE_REFRESH, true);
        this.refresh(bundle);
    }

    public void refresh(){
        refresh(null);
    }

    private void refresh(final Bundle args){
        if (!isUsable()) return;

        this.getLoaderManager().restartLoader(0, args, this);
    }

    protected abstract int getErrorMessage(Exception exception);

    public void onLoadFinished(Loader<List<E>> loader, List<E> items){
        if (!isUsable()) return;
        this.swipeLayout.setRefreshing(false);
        Exception exception = this.getException(loader);

        if (exception != null){
            this.showError(exception, this.getErrorMessage(exception));
            this.showList();
            return;
        }

        this.items = items;

        this.getListAdapter().getWrappedAdapter().setItems(items.toArray());

        this.showList();
    }


    protected HeaderFooterListAdapter<SingleTypeAdapter<E>>  createAdapter() {
        SingleTypeAdapter<E> wrapped = createAdapter(this.items);
        return new HeaderFooterListAdapter<>(getListView(),wrapped);
    }

    protected abstract SingleTypeAdapter<E> createAdapter(final List<E> items);

    protected void showList(){
        this.setListShown(true, this.isResumed());
    }

    @Override
    public void onLoaderReset(Loader<List<E>> loader) {

    }

    protected void showError(final Exception e, final int defaultMessage){
        this.showToastMessage(e.getMessage());
    }

    protected Exception getException(final  Loader<List<E>> loader){
        return null;
    }

    protected void refreshWithProgress(){
        this.items.clear();
        this.setListShown(false);
        this.refresh();
    }

    private ListView getListView() {
        return this.listView;
    }

    protected HeaderFooterListAdapter<SingleTypeAdapter<E>> getListAdapter(){
        if (this.listView != null)
            return (HeaderFooterListAdapter<SingleTypeAdapter<E>>) this.listView.getAdapter();
        return null;
    }

    protected ItemListFragment<E> notifyDataSetChanged(){
        HeaderFooterListAdapter<SingleTypeAdapter<E>> root = this.getListAdapter();
        if (root != null){
            SingleTypeAdapter<E> typeAdapter = root.getWrappedAdapter();
            if (typeAdapter != null)
                typeAdapter.notifyDataSetChanged();
        }
        return this;
    }

    protected ItemListFragment<E> setListAdapter(final ListAdapter adapter){
        if (this.listView != null) this.listView.setAdapter(adapter);
        return this;
    }

    private ItemListFragment<E> fadeIn(final View view, final boolean animate){
        if (view != null){
            if (animate) view.startAnimation(AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in));
            else view.clearAnimation();
        }
        return this;
    }

    private ItemListFragment<E> show(final View view){
        ViewUtils.setGone(view,false);
        return this;
    }

    private ItemListFragment<E> hiden(final View view){
        ViewUtils.setGone(view,false);
        return this;
    }

    protected boolean isUsable() {
        return getActivity() != null;
    }

    public ItemListFragment<E> setListShown(final boolean shown){
        return this.setListShown(shown, true);
    }

    public ItemListFragment<E> setListShown(final boolean shown, final boolean animate) {
        if (!isUsable()) return this;

        if (shown == this.listShown) {
            if (shown){
                if (this.items.isEmpty()) hiden(this.listView).show(this.emptyView);
            }else {
                hiden(this.emptyView).show(this.listView);
            }
            return this;
        }

        this.listShown = shown;

        if (shown)
            if (!this.items.isEmpty())
                hiden(this.progressBar).hiden(this.emptyView).fadeIn(this.listView, animate).show(this.emptyView);
            else
                hiden(this.progressBar).hiden(this.listView).fadeIn(this.emptyView, animate).show(this.emptyView);
        else
            hiden(this.listView).hiden(emptyView).fadeIn(this.progressBar,animate).show(progressBar);

        return this;
    }

    protected ItemListFragment<E> setEmptyText(final String message){
        if (this.emptyView != null)
            this.emptyView.setText(message);
        return this;
    }

    protected ItemListFragment<E> setEmtpyText(final int resId){
        if (this.emptyView != null)
            this.emptyView.setText(resId);
        return this;
    }

    private boolean onListItemLongClick(ListView parent, View view, int position, long id) {
        return false;
    }

    private void onListItemClick(ListView parent, View view, int position, long id) {

    }
}
