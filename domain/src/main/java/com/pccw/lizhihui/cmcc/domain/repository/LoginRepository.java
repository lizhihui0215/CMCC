package com.pccw.lizhihui.cmcc.domain.repository;


import com.pccw.lizhihui.cmcc.domain.User;

import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public interface LoginRepository {
    Observable<User> user(String username, String password);
}
