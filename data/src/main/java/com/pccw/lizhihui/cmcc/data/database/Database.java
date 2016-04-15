package com.pccw.lizhihui.cmcc.data.database;

import java.util.List;

/**
 * Created by lizhihui on 4/14/16.
 */
public interface Database<D, T> {
    public void call(DBAction1<D, T> action1, Object entity);

    public void call(DBAction1<D, T> action1, List<? super Object> list);
}
