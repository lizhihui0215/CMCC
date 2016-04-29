package com.pccw.lizhihui.cmcc.domain.exception;

/**
 * Created by lizhihui on 4/29/16.
 */
public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
