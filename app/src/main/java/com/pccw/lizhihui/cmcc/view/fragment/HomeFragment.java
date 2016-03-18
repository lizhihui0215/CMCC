package com.pccw.lizhihui.cmcc.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.internal.di.components.HomeComponent;
import com.pccw.lizhihui.cmcc.view.HomeDetailsView;

import butterknife.ButterKnife;


public class HomeFragment extends BaseFragment implements HomeDetailsView{


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(HomeComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,fragmentView);
        return fragmentView;
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
        return getActivity().getApplication();
    }
}
