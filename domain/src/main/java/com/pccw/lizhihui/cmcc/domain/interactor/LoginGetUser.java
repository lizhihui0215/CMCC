package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.LoginRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public class LoginGetUser extends LoginCase {

    private String username;

    private String password;

    private  final LoginRepository loginRepository;

    @Inject
    public LoginGetUser(LoginRepository loginRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);
        this.loginRepository = loginRepository;
    }

    @Override
    protected Observable buildLoginUseCaseObservable() {
        return this.loginRepository.user(this.username,this.password);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void execute(Subscriber UseCaseSubscriber) {
        this.subscription = this.buildLoginUseCaseObservable()
                .doOnNext(new LoginGetUser.LoginSubscriber())
                .subscribeOn(Schedulers.from(this.threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(UseCaseSubscriber);
    }

    private final class LoginSubscriber  implements Action1 {

        @Override
        public void call(Object o) {
            Object test = o;
        }
    }

    public void login(String username, String password,
                      Subscriber LoginCaseSubscriber) {
        this.username = username;
        this.password = password;
        this.execute(LoginCaseSubscriber);
    }
}
