package com.pccw.lizhihui.cmcc.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.components.LoginComponent;
import com.pccw.lizhihui.cmcc.presenter.LoginPresenter;
import com.pccw.lizhihui.cmcc.view.LoginView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class LoginFragment extends BaseFragment implements LoginView {

    @Bind(R.id.tv_username) TextView tv_username;
    @Bind(R.id.tv_password) TextView tv_password;

    @Inject LoginPresenter loginPresenter;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(LoginComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this,fragmentView);

        return fragmentView;
    }

    @OnClick(R.id.login_button)
    public void loginButtonPressed(Button button){

        this.loginPresenter.login(tv_username.getText().toString(),tv_password.getText().toString());

        Log.v("login button pressed", "login");
    }

    @Override
    public void showLoading() {}

    @Override
    public void hideLoading() {}

    @Override
    public void showRetry() {}

    @Override
    public void hidenRetry() {}

    @Override
    public void showError(String message) {}

    @Override
    public Context context() {
        return this.getActivity().getApplication();
    }
}
