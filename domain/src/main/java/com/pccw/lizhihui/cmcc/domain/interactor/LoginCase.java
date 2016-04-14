package com.pccw.lizhihui.cmcc.domain.interactor;

import com.pccw.lizhihui.cmcc.domain.executor.PostExecutionThread;
import com.pccw.lizhihui.cmcc.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by lizhihui on 4/1/16.
 */
public abstract class LoginCase {
    protected final ThreadExecutor threadExecutor;

    protected final PostExecutionThread postExecutionThread;

    protected Subscription subscription = Subscriptions.empty();

    protected LoginCase(ThreadExecutor threadExecutor,
                        PostExecutionThread postExecutionThread){
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected abstract Observable buildLoginUseCaseObservable();
    @SuppressWarnings("unchecked")
    protected abstract void execute(Subscriber UseCaseSubscriber) ;




    public abstract void login(String username, String password, Subscriber UseCaseSubscriber);
}
