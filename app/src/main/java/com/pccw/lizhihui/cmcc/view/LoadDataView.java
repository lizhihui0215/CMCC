package com.pccw.lizhihui.cmcc.view;

import android.content.Context;

/**
 * Created by lizhihui on 3/17/16.
 *
 * Interface representing a View that will use to load data.
 */
public interface LoadDataView {

    /**
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    void showRetry();

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    void hidenRetry();

    /**
     * Show an error message
     * @param message A string reporesenting an error
     */
    void showError(String message);

    /**
     * Get a {@link android.content.Context}.
     * @return
     */
    Context context();

}
