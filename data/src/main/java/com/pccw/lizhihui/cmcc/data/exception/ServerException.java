package com.pccw.lizhihui.cmcc.data.exception;

/**
 * Created by lizhihui on 4/23/16.
 */
public class ServerException extends Exception {

    private String code;

    public ServerException() {
        super();
    }

    public ServerException(final String message, String code) {
        super(message);
        this.code = code;
    }

    public ServerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ServerException(final Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
