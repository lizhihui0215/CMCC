package com.pccw.lizhihui.cmcc.data.net;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.entity.HTTPResult;
import com.pccw.lizhihui.cmcc.data.entity.LoginParameters;
import com.pccw.lizhihui.cmcc.domain.User;

import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by lizhihui on 4/1/16.
 *
 *
 */
@Singleton
public class NetworkServicesImpl implements NetworkServices {

    private final Context context;

    private User loginUser;

    protected Retrofit retrofit;

    public NetworkServicesImpl(Context context) {
        if (context == null ) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();

        this.setupRetrofit();
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    private void setupRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        this.retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Override
    public Observable<User> userEntityBy(String username, String password) {

        UserService service = this.retrofit.create(UserService.class);
        LoginParameters loginParameters = new LoginParameters(username, password);

        return service.getUser(loginParameters).map(new HTTPResultFunc<User>());
    }

    private class HTTPResultFunc<T> implements Func1<HTTPResult<T>, T>{

        @Override
        public T call(HTTPResult<T> tBaseEntity) {
            return (T) tBaseEntity.getResults();
        }
    }
}
