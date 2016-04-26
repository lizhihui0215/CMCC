package com.pccw.lizhihui.cmcc.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import com.pccw.lizhihui.cmcc.domain.LaunchOption;
import com.pccw.lizhihui.cmcc.domain.interactor.DefaultSubscriber;
import com.pccw.lizhihui.cmcc.domain.interactor.UseCase;
import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.view.MainView;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by lizhihui on 4/16/16.
 *
 */
@PerActivity
public class MainPresenter implements Presenter {

    private final UseCase launchOptionUseCase;
    private MainView mainView;

    @Inject
    public MainPresenter(@Named("GetLaunchOption") UseCase getUserUseCase) {
        this.launchOptionUseCase = getUserUseCase;
    }

    public void setView(@NonNull MainView mainView){
        this.mainView = mainView;
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
            MainPresenter.this.mainView.navigationToLogin();
        }

        @Override
        public void onNext(LaunchOption launchOption) {
            switch (launchOption){
                case LAUNCH_OPTION_FROM_LOGIN:
                    MainPresenter.this.mainView.navigationToLogin();
                    break;
                case LAUNCH_OPTION_FROM_MAIN:
                    MainPresenter.this.mainView.navigationToMain();
                    break;
            }
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
