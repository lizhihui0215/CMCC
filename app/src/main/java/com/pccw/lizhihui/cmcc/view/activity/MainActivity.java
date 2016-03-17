package com.pccw.lizhihui.cmcc.view.activity;

import android.os.Bundle;
import com.pccw.lizhihui.cmcc.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.navigator.navigateToLogin(this);
    }
}
