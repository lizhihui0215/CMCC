package com.pccw.lizhihui.cmcc.data.cache;

import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;

import rx.Observable;

/**
 * Created by lizhihui on 3/16/16.
 */
public interface UserCache {

    Observable<UserEntity> get();

    void put(UserEntity user) throws Exception;

}
