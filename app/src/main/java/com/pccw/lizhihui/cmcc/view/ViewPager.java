package com.pccw.lizhihui.cmcc.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lizhihui on 4/28/16.
 * {@link ViewPager} extension with support for horizontally scrolling an
 */
public class ViewPager extends android.support.v4.view.ViewPager{
    public ViewPager(Context context) {
        super(context);
    }

    public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Set current item and return whether the item changed
     * <p>
     * This method does not call {@link #setCurrentItem(int)} unless the item
     * parameter differs from the current item
     *
     * @param item
     * @return true if set, false if same
     */
    public boolean setItem(final int item){
        final boolean changed = item != this.getCurrentItem();
        if (changed){
            this.setCurrentItem(item, false);
        }
        return changed;
    }

    /**
     * Set current item, invoke the listener if changes, and return whether the
     * item changed
     * <p>
     * This method does not call {@link #setCurrentItem(int)} unless the item
     * parameter differs from the current item
     *
     * @param item
     * @param listener
     * @return true if set, false if same
     */
    public boolean setItem(final int item, final OnPageChangeListener listener){
        final boolean changed = setItem(item);
        if (changed && listener != null){
            listener.onPageSelected(item);
        }
        return changed;
    }

    /**
     * Schedule a call to {@link #setItem(int)} to occur on the UI-thread
     *
     * @param item
     * @param listener
     */
    public void scheduleSetItem(final int item,
                                final OnPageChangeListener listener){
        post(new Runnable() {
            @Override
            public void run() {
                setItem(item,listener);
            }
        });
    }

    /**
     * Schedule a call to {@link #setItem(int)} to occur on the UI-thread
     *
     * @param item
     */
    public void scheduleSetItem(final int item){
        post(new Runnable() {
            @Override
            public void run() {
                setItem(item);
            }
        });
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        return super.canScroll(v, checkV, dx, x, y);
    }
}
