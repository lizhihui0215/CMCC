package com.pccw.lizhihui.cmcc.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.pccw.lizhihui.cmcc.domain.User;
import com.pccw.lizhihui.cmcc.domain.interactor.DefaultSubscriber;
import com.pccw.lizhihui.cmcc.domain.interactor.LoginCase;
import com.pccw.lizhihui.cmcc.view.LoginView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public class LoginPresenter implements Presenter {

    private LoginView loginView;

    private LoginCase getUserUseCase;

    @Inject
    public LoginPresenter(@Named("login") LoginCase getUserUseCase){
        this.getUserUseCase = getUserUseCase;
    }

    public void setView(@NonNull LoginView loginView){
        this.loginView = loginView;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {
        
    }

    @Override
    public void destroy() {

    }

    public void login(String username, String password) {
        this.getUserUseCase.login(username,password,new LoginSubscriber());
    }


    private final class LoginSubscriber extends DefaultSubscriber<User> {
        @Override
        public void onCompleted() {
            Log.v("completed " , "login");
        }

        @Override
        public void onError(Throwable e) {
            Log.v("ex " + e, "login");
        }

        @Override
        public void onNext(User user) {
            Log.v("next " + user , "login");
        }
    }
}
