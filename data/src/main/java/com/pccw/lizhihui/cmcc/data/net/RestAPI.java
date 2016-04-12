package com.pccw.lizhihui.cmcc.data.net;

import com.pccw.lizhihui.cmcc.data.entity.LoginParameters;
import com.pccw.lizhihui.cmcc.data.entity.UserEntity;

import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 */
public interface RestAPI {
    String API_BASE_URL = "http:/114.251.247.82:8080/eamapp/";
    Observable<UserEntity> userEntityBy(String username, String password);
}
