package com.pccw.lizhihui.cmcc.data.entity;

/**
 * Created by lizhihui on 4/1/16.
 */
public class UserEntity {
    private String username;
    private String password;
    private String op;
    private String type;

    public UserEntity(String username, String password, String op, String type) {
        this.username = username;
        this.password = password;
        this.op = op;
        this.type = type;
    }

    public UserEntity(String username, String password) {

        this.username = username;
        this.password = password;
        this.op = "authentication";
        this.type = "0";
    }
}
