package com.pccw.lizhihui.cmcc.data.net;


import com.pccw.lizhihui.cmcc.data.entity.UserEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 */
public interface CMCCService {
    @POST("eamapp/entry/services/open/srv/user")
    Observable<UserEntity> getUser(@Body UserEntity userEntity);
}
