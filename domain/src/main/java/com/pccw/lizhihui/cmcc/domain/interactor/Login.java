package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;
import com.pccw.lizhihui.cmcc.domain.repository.LoginRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by lizhihui on 4/1/16.
 *
 */
public class Login extends UseCase {

    private  final LoginRepository loginRepository;

    @Inject
    public Login(LoginRepository loginRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor,postExecutionThread);
        this.loginRepository = loginRepository;
    }

//    @Override
//    protected Observable buildLoginUseCaseObservable() {
//        return this.loginRepository.user(this.username,this.password);
//    }

    @Override
    protected Observable buildUseCaseObservable(Object... args) {
        String username = (String) args[0];

        String password = (String) args[1];

        return this.loginRepository.user(username,password);
    }



    public void login(String username, String password,
                      Subscriber LoginCaseSubscriber) {
//        this.username = username;
//        this.password = password;
        this.execute(LoginCaseSubscriber);
    }
}
