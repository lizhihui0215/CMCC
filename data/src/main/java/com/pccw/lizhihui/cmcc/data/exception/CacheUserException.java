package com.pccw.lizhihui.cmcc.data.exception;

/**
 * Created by lizhihui on 4/14/16.
 */
public class CacheUserException extends Exception{
    public CacheUserException() {
        super();
    }

    public CacheUserException(final String message) {
        super(message);
    }

    public CacheUserException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CacheUserException(final Throwable cause) {
        super(cause);
    }
}
