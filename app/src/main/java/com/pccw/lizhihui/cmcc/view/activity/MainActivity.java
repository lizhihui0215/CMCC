package com.pccw.lizhihui.cmcc.view.activity;

import android.os.Bundle;
import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.DaggerMainComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.MainComponent;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent>{

    private MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getApplicationComponent().inject(this);

        this.initializeInjector();

        this.navigator.navigateToLogin(this);
    }

    private void initializeInjector() {
        this.mainComponent = DaggerMainComponent.builder()
                .applicationComponent(this.getApplicationComponent())
                .activityModule(this.getActivityMoudle())
                .build();
    }

    @Override
    public MainComponent getComponent() {
        return this.mainComponent;
    }
}
