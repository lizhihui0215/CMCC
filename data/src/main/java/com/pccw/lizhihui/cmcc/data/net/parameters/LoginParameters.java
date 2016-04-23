package com.pccw.lizhihui.cmcc.data.net.parameters;

/**
 * Created by lizhihui on 4/1/16.
 */
public class LoginParameters extends BaseParameter {
    private String account;
    private String password;
    private String type;

    public LoginParameters(String account, String password) {

        this.account = account;
        this.password = password;
        this.op = "authentication";
        this.type = "0";
    }
}
