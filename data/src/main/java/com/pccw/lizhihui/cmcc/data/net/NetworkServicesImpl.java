package com.pccw.lizhihui.cmcc.data.net;

import android.content.Context;

import com.pccw.lizhihui.cmcc.data.entity.AccessTokenEntity;
import com.pccw.lizhihui.cmcc.data.entity.HTTPResult;
import com.pccw.lizhihui.cmcc.data.exception.ServerException;
import com.pccw.lizhihui.cmcc.data.net.parameters.AccessTokenParameters;
import com.pccw.lizhihui.cmcc.data.net.parameters.LoginParameters;
import com.pccw.lizhihui.cmcc.data.greendao.gen.UserEntity;
import javax.inject.Inject;
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

    private UserEntity loginUser;

    protected Retrofit retrofit;

    @Inject
    public NetworkServicesImpl(Context context) {
        if (context == null ) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }

        this.context = context;

        this.setupRetrofit();
    }

    @Override
    public UserEntity getLoginUser() {
        return this.loginUser;
    }

    @Override
    public void setLoginUser(UserEntity loginUser) {
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
    public Observable<UserEntity> userEntityBy(String username, String password) {
        UserService service = getUserService();

        LoginParameters loginParameters = new LoginParameters(username, password);

        return service.getUser(loginParameters).flatMap(new HandleError<>());
    }

    @Override
    public Observable<AccessTokenEntity> fetchAccessToken(String accessToken) {
         return this.getUserService().fetchAccessToken(new AccessTokenParameters(accessToken))
                 .flatMap(new HandleError<>());
    }

    private class HandleError<T> implements Func1<HTTPResult<T>, Observable<T>>{
        @Override
        public rx.Observable<T> call(HTTPResult<T> httpResult) {
            Observable<T> objectObservable;
            if (httpResult.getStatus().endsWith("Y")){
                objectObservable = Observable.create(subscriber -> {
                    subscriber.onNext(httpResult.getResults());
                    subscriber.onCompleted();
                });
            }else {
                objectObservable = Observable.error(new ServerException(httpResult.getErrorName(),httpResult.getErrorCode()));
            };
            return objectObservable;
        }
    }

    private UserService getUserService() {
        return this.retrofit.create(UserService.class);
    }
}
