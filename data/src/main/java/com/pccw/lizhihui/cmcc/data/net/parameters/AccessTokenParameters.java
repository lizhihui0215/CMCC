package com.pccw.lizhihui.cmcc.data.net.parameters;

/**
 * Created by lizhihui on 4/23/16.
 */
public class AccessTokenParameters extends BaseParameter{

    private final String accessToken;

    public AccessTokenParameters(String accessToken) {
        this.accessToken = accessToken;

        this.op = "accessToken";
    }
}
