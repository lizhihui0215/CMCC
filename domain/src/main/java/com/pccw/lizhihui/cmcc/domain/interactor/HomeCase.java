package com.pccw.lizhihui.cmcc.domain.interactor;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by lizhihui on 3/30/16.
 *
 */
public abstract class HomeCase {

    private Subscription subscription = Subscriptions.empty();

    protected abstract rx.Observable buildHomeCaseObservable();

    public void execute(Subscriber HomeCaseSubscriber){
        this.subscription = this.buildHomeCaseObservable()
                            .subscribe(HomeCaseSubscriber);

    }

    public void unsubscribe(){
        if (!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

}
