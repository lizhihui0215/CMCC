package com.pccw.lizhihui.cmcc.data.database;

public interface DBAction1<Q,T>{

    void call(Q q, T t);
}
