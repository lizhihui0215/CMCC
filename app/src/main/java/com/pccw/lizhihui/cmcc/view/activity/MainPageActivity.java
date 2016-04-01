package com.pccw.lizhihui.cmcc.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.domain.Province;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.DaggerMainPageComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.MainPageComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.HomeModule;
import com.pccw.lizhihui.cmcc.internal.di.modules.MainPageModule;
import com.pccw.lizhihui.cmcc.view.fragment.MainPageFragment;

import butterknife.ButterKnife;

public class MainPageActivity extends BaseActivity implements HasComponent<MainPageComponent>,
MainPageFragment.MainPageContainerListener{

    private MainPageComponent mainPageComponent;

    public static Intent getCallingIntent(Context context) {
        Intent callingIntent = new Intent(context, MainPageActivity.class);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);

        ButterKnife.bind(this);

        this.initializeActivity(savedInstanceState);

        this.initializeInjector();
    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            addFragment(R.id.container_fragment,new MainPageFragment());
        }
    }

    private void initializeInjector() {
        this.mainPageComponent = DaggerMainPageComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityMoudle())
                .mainPageModule(getMainPageMoudle())
                .homeModule(getHomeModule())
                .build();
    }

    public MainPageModule getMainPageMoudle(){
        return new MainPageModule();
    }

    public HomeModule getHomeModule(){
        return new HomeModule(Province.UNIVERSAL);
    }

    @Override
    public MainPageComponent getComponent() {
        return this.mainPageComponent;
    }

    @Override
    public void onPageSelected(int position) {
        Log.v("position" + position,"MainActivity");
    }
}
