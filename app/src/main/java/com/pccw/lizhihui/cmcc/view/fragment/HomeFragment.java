package com.pccw.lizhihui.cmcc.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.model.HomeModel;
import com.pccw.lizhihui.cmcc.presenter.HomePresenter;
import com.pccw.lizhihui.cmcc.view.HomeView;
import com.pccw.lizhihui.cmcc.view.adapter.HomeGridViewAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeFragment extends BaseFragment implements HomeView {

    @Inject HomePresenter homePresenter;

    @Inject HomeGridViewAdapter homeGridViewAdapter;

    @Bind(R.id.gv_container) GridView gv_container;

    @Bind(R.id.home_task_number) TextView tv_mytaskNumber;

    @Inject
    public HomeFragment() {
        // Required empty public constructor
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.homePresenter.setView(this);
        if (savedInstanceState == null){
            this.loadHomeList();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,fragmentView);

        this.setupGridView();
        return fragmentView;
    }

    private void setupGridView() {
        this.gv_container.setAdapter(this.homeGridViewAdapter);
    }

    private void loadHomeList(){
        this.homePresenter.initialize();
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
        return getActivity().getApplication();
    }

    @Override
    public void renderHomeList(Collection<HomeModel> homeModels) {
        if (homeModels != null){
            this.homeGridViewAdapter.setHomeCollection(homeModels);
        }
    }

    @Override
    public void renderMyTaskNumebr(Integer taskNumber) {
        if (taskNumber > 0)
            this.tv_mytaskNumber.setVisibility(View.VISIBLE);
        else
            this.tv_mytaskNumber.setVisibility(View.GONE);

        this.tv_mytaskNumber.setText(taskNumber.toString());
    }
}
