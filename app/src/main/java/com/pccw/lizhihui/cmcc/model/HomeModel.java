package com.pccw.lizhihui.cmcc.model;

import android.support.annotation.DrawableRes;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class HomeModel {

    private @DrawableRes int resid;

    private String title;

    public int getResid() {
        return this.resid;
    }

    public void setResid(@DrawableRes int resid) {
        this.resid = resid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "HomeModel{" +
                "resid=" + resid +
                ", title='" + title + '\'' +
                '}';
    }
}
