package com.pccw.lizhihui.cmcc.data.cache;

import com.pccw.lizhihui.cmcc.domain.User;

import rx.Observable;

/**
 * Created by lizhihui on 3/16/16.
 */
public interface UserCache {

    Observable<User> get(String account, String password);

    void put(User user) throws Exception;

}
