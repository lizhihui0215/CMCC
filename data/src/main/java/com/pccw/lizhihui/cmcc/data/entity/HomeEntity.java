package com.pccw.lizhihui.cmcc.data.entity;

import android.support.annotation.DrawableRes;



/**
 * Created by lizhihui on 3/30/16.
 *
 */
public class HomeEntity {
    private  @DrawableRes int resId;
    private String name;

    public HomeEntity(int resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
