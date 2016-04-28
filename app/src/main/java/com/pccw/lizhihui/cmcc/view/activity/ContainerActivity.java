package com.pccw.lizhihui.cmcc.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import com.pccw.lizhihui.cmcc.R;
import com.pccw.lizhihui.cmcc.domain.Province;
import com.pccw.lizhihui.cmcc.internal.di.HasComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.DaggerMainPageComponent;
import com.pccw.lizhihui.cmcc.internal.di.components.MainPageComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.HomeModule;
import com.pccw.lizhihui.cmcc.internal.di.modules.MainPageModule;
import com.pccw.lizhihui.cmcc.view.fragment.MainPageFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ContainerActivity extends BaseActivity implements HasComponent<MainPageComponent>,
MainPageFragment.MainPageContainerListener{

    private MainPageComponent mainPageComponent;

    @Bind(R.id.toolbar) Toolbar toolbar;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ContainerActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_page);

        ButterKnife.bind(this);

        // Always cast your custom Toolbar here, and set it as the ActionBar.
        setSupportActionBar(toolbar);

        // Get the ActionBar here to configure the way it behaves.
        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu); // set a custom icon for the default home button
        assert ab != null;
        ab.setDisplayShowHomeEnabled(true); // show or hide the default home button
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
        ab.setDisplayShowTitleEnabled(true); // disable the default title element here (for centered title)

        this.initializeActivity(savedInstanceState);

        this.initializeInjector();
    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            addFragment(R.id.container,new MainPageFragment());
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
