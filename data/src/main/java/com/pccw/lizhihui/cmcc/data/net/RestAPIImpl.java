package com.pccw.lizhihui.cmcc.data.net;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.entity.LoginParameters;
import com.pccw.lizhihui.cmcc.data.entity.UserEntity;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by lizhihui on 4/1/16.
 *
 *
 */
public class RestAPIImpl implements RestAPI {

    private final Context context;

    public RestAPIImpl(Context context) {
        if (context == null ) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
    }

    @Override
    public Observable<UserEntity> userEntityBy(String username, String password) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        CMCCService service = retrofit.create(CMCCService.class);
        LoginParameters loginParameters = new LoginParameters(username, password);
        return service.getUser(loginParameters);
    }
}
