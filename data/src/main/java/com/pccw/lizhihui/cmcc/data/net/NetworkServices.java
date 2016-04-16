package com.pccw.lizhihui.cmcc.data.net;


import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;

import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public interface NetworkServices {
    String API_BASE_URL = "http:/114.251.247.82:8080/";

    public UserEntity getLoginUser();

    public void setLoginUser(UserEntity loginUser);

    Observable<UserEntity> userEntityBy(String username, String password);

}
