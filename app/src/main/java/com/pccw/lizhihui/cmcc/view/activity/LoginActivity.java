package com.pccw.lizhihui.cmcc.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.DaggerLoginComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.LoginComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.LoginModule;
import com.pccw.lizhihui.cmcc.view.fragment.LoginFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements HasComponent<LoginComponent>{

    private LoginComponent loginComponent;

    @Bind(R.id.toolbar) Toolbar toolbar;

    public static Intent getCallingIntent(Context context){
        return new Intent(context,LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        // Always cast your custom Toolbar here, and set it as the ActionBar.
        setSupportActionBar(toolbar);

        // Get the ActionBar here to configure the way it behaves.
        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu); // set a custom icon for the default home button
        ab.setDisplayShowHomeEnabled(true); // show or hide the default home button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
        ab.setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title)
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
