package com.pccw.lizhihui.cmcc.domain.exception;

/**
 * Created by lizhihui on 4/29/16.
 */
public class DefaultErrorBundle implements ErrorBundle {

    private static final String DEFAULT_ERROR_MSG = "Unknown error";
    private final Exception exception;

    public DefaultErrorBundle(Exception exception){
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return this.exception;
    }

    @Override
    public String getErrorMessage() {
        return (exception != null) ? this.exception.getMessage() : DEFAULT_ERROR_MSG;
    }
}
