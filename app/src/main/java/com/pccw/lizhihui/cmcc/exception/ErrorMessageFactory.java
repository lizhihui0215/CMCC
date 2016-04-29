package com.pccw.lizhihui.cmcc.exception;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.data.exception.ServerException;

/**
 * Created by lizhihui on 4/29/16.
 */
public class ErrorMessageFactory {

    private ErrorMessageFactory(){

    }

    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);

        if (exception instanceof NetworkErrorException){
            message = exception.getMessage();
        }else if (exception instanceof ServerException){
            message = exception.getMessage();
        }

        return message;
    }
}
