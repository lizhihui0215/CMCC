package com.pccw.lizhihui.cmcc.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pccw.lizhihui.cmcc.AndroidApplication;
import com.pccw.lizhihui.cmcc.internal.di.components.ApplicationComponent;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityMoudle;
import com.pccw.lizhihui.cmcc.navigation.Navigator;
import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {

    @Inject Navigator navigator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Add a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment){
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();

        fragmentTransaction.add(containerViewId, fragment);

        fragmentTransaction.commit();
    }

    /**
     * Get the Main Application component for dependency injection
     *
     * @return
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication)getApplication()).getApplicationComponent();
    }

    protected ActivityMoudle getActivityMoudle(){ return new ActivityMoudle(this); }
}
