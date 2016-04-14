package com.pccw.lizhihui.cmcc.domain;

import java.util.List;

/**
 * Created by lizhihui on 4/11/16.
 *
 */
public class User {
    private String phone;
    private String accessToken;
    private String token;
    private String userId;
    private String userName;
    private String account;
    private List<Deparment> deptList;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Deparment> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Deparment> deptList) {
        this.deptList = deptList;
    }

    public class Deparment{
        private String deptName;
        private String deptCode;
        private String parentCode;
        private String deptId;

//        public Deparment(String deptName, String deptCode, String parentCode, String deptId) {
//            this.deptName = deptName;
//            this.deptCode = deptCode;
//            this.parentCode = parentCode;
//            this.deptId = deptId;
//        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getDeptCode() {
            return deptCode;
        }

        public void setDeptCode(String deptCode) {
            this.deptCode = deptCode;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }
    }

}

