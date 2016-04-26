package com.pccw.lizhihui.cmcc.view.activity;

import android.content.Context;
import android.os.Bundle;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.MainComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.MainMoudle;
import com.pccw.lizhihui.cmcc.presenter.MainPresenter;
import com.pccw.lizhihui.cmcc.view.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent>, MainView{

    private MainComponent mainComponent;

    @Inject MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeInjector();

        this.mainComponent.inject(this);
        this.mainPresenter.setView(this);
        this.mainPresenter.getLaunchOption();
    }

    private void initializeInjector() {
        this.mainComponent = this.getApplicationComponent()
                .mainComponent(getMainModule());
    }



    @Override
    public MainComponent getComponent() {
        return this.mainComponent;
    }

    public MainMoudle getMainModule() {
        return new MainMoudle();
    }

    @Override
    public void navigationToLogin() {
        this.navigator.navigateToLogin(this);
    }

    @Override
    public void navigationToMain(){
        this.navigator.navigateToMainPage(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hidenRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return getApplicationContext();
    }
}
