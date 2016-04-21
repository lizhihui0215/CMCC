package com.pccw.lizhihui.cmcc.presenter;

import android.content.Context;
import android.util.Log;

import com.pccw.lizhihui.cmcc.domain.LaunchOption;
import com.pccw.lizhihui.cmcc.domain.interactor.DefaultSubscriber;
import com.pccw.lizhihui.cmcc.domain.interactor.UseCase;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by lizhihui on 4/16/16.
 *
 */
public class MainPresenter implements Presenter {

    private final UseCase launchOptionUseCase;

    @Inject
    public MainPresenter(@Named("GetLaunchOption") UseCase getUserUseCase) {
        this.launchOptionUseCase = getUserUseCase;
    }

    public void getLaunchOption(){
        this.launchOptionUseCase.execute(new LaunchOptionSubscriber());
    }

    private final class LaunchOptionSubscriber extends DefaultSubscriber<LaunchOption> {
        @Override
        public void onCompleted() {
            Log.v("MainPresenter","onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.v("MainPresenter","onError");
        }

        @Override
        public void onNext(LaunchOption launchOption) {
            Log.v("MainPresenter","onNext" + launchOption);
        }
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
}
