package com.pccw.lizhihui.cmcc.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.DaggerLoginComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.LoginComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.LoginModule;
import com.pccw.lizhihui.cmcc.view.fragment.LoginFragment;

import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements HasComponent<LoginComponent>{

    private LoginComponent loginComponent;


    public static Intent getCallingIntent(Context context){
        return new Intent(context,LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        this.initializeActivity(savedInstanceState);

        this.initializeInjector();
    }

    private void initializeInjector() {
        this.loginComponent = DaggerLoginComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityMoudle())
                .loginModule(getLoginMoudle())
                .build();
    }

    private LoginModule getLoginMoudle() {
        return new LoginModule();
    }


    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            addFragment(R.id.login_container,new LoginFragment());
        }
    }

    public void navigationToMain(){
        this.navigator.navigateToMainPage(this);
    }

    @Override
    public LoginComponent getComponent() {
        return this.loginComponent;
    }
}
