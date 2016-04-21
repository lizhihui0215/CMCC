package com.pccw.lizhihui.cmcc.view.activity;

import android.os.Bundle;
import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.DaggerMainComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.MainComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.MainMoudle;
import com.pccw.lizhihui.cmcc.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent>{

    private MainComponent mainComponent;

    @Inject MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeInjector();

        this.getApplicationComponent().inject(this);
        this.navigator.navigateToLogin(this);
        this.mainPresenter.getLaunchOption();
    }

    private void initializeInjector() {
        this.mainComponent = DaggerMainComponent.builder()
                .applicationComponent(this.getApplicationComponent())
                .activityModule(this.getActivityMoudle())
                .mainMoudle(getMainModule())
                .build();
    }



    @Override
    public MainComponent getComponent() {
        return this.mainComponent;
    }

    public MainMoudle getMainModule() {
        return new MainMoudle();
    }
}
