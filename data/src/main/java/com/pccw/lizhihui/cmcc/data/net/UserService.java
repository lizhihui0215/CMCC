package com.pccw.lizhihui.cmcc.data.net;


import com.pccw.lizhihui.cmcc.data.entity.AccessTokenEntity;
import com.pccw.lizhihui.cmcc.data.entity.HTTPResult;
import com.pccw.lizhihui.cmcc.data.net.parameters.AccessTokenParameters;
import com.pccw.lizhihui.cmcc.data.net.parameters.LoginParameters;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public interface UserService {
    @POST("eamapp/entry/services/open/srv/user")
    Observable<HTTPResult<UserEntity>> getUser(@Body LoginParameters loginParameters);

    @POST("eamapp/entry/services/open/srv/user")
    Observable<HTTPResult<AccessTokenEntity>> fetchAccessToken(@Body AccessTokenParameters accessTokenParameters);
}
