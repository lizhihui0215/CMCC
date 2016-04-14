package com.pccw.lizhihui.cmcc.data.entity;

/**
 * Created by lizhihui on 4/13/16.
 */
public class HTTPResult<T> {
    private String errorCode;

    private String errorName;

    private String status;

    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
