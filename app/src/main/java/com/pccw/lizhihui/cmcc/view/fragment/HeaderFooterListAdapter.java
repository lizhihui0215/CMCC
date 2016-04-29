package com.pccw.lizhihui.cmcc.view.fragment;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;

import java.util.ArrayList;

/**
 * Utility adapter that supports adding headers and footers
 *
 * @param <E>
 */
public class HeaderFooterListAdapter<E extends BaseAdapter> extends
        HeaderViewListAdapter {

    private final ListView list;

    private final ArrayList<FixedViewInfo> headers;

    private final ArrayList<FixedViewInfo> footers;

    private final E wrapped;

    /**
     * Create header footer adapter
     *
     * @param view
     * @param adapter
     */
    public HeaderFooterListAdapter(ListView view, E adapter) {
        this(new ArrayList<FixedViewInfo>(), new ArrayList<FixedViewInfo>(),
                view, adapter);
    }

    private HeaderFooterListAdapter(ArrayList<FixedViewInfo> headerViewInfos,
                                    ArrayList<FixedViewInfo> footerViewInfos, ListView view, E adapter) {
        super(headerViewInfos, footerViewInfos, adapter);

        headers = headerViewInfos;
        footers = footerViewInfos;
        list = view;
        wrapped = adapter;
    }

    public HeaderFooterListAdapter<E> addHeader(View view){
        return addHeader(view,null,false);
    }

    public HeaderFooterListAdapter<E> addHeader(View view, Object data, boolean isSelectable){
        FixedViewInfo info = this.list.new FixedViewInfo();
        info.view = view;
        info.data = data;
        info.isSelectable = isSelectable;

        this.headers.add(info);
        this.wrapped.notifyDataSetChanged();
        return this;
    }

    public HeaderFooterListAdapter<E> addFooter(View view){
        return addFooter(view, null, false);
    }

    public HeaderFooterListAdapter<E> addFooter(View view, Object data, boolean isSelectable){
        FixedViewInfo info = this.list.new FixedViewInfo();
        info.view = view;
        info.data = data;
        info.isSelectable = isSelectable;

        this.footers.add(info);
        this.wrapped.notifyDataSetChanged();
        return this;
    }

    @Override
    public boolean removeHeader(View v) {
        boolean removed = super.removeHeader(v);

        if (removed)
            wrapped.notifyDataSetChanged();

        return removed;
    }

    public boolean clearHeaders(){
        boolean removed = false;
        if (this.headers.isEmpty()){
            FixedViewInfo[] infos = this.headers.toArray(new FixedViewInfo[this.headers.size()]);

            for (FixedViewInfo info : infos) {
                removed = super.removeHeader(info.view) || removed;
            }
        }

        if (removed)
            this.wrapped.notifyDataSetChanged();

        return removed;
    }

    public boolean clearFooters() {
        boolean removed = false;
        if (!footers.isEmpty()) {
            FixedViewInfo[] infos = footers.toArray(new FixedViewInfo[footers
                    .size()]);
            for (FixedViewInfo info : infos)
                removed = super.removeFooter(info.view) || removed;
        }
        if (removed)
            wrapped.notifyDataSetChanged();
        return removed;
    }

    @Override
    public boolean removeFooter(View v) {
        boolean removed = super.removeFooter(v);
        if (removed)
            wrapped.notifyDataSetChanged();
        return removed;
    }

    @Override
    public E getWrappedAdapter() {
        return wrapped;
    }

    @Override
    public boolean isEmpty() {
        return wrapped.isEmpty();
    }
}
