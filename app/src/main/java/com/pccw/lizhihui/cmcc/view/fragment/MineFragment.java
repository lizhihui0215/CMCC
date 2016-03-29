package com.pccw.lizhihui.cmcc.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pccw.lizhihui.cmcc.R;
import javax.inject.Inject;
import butterknife.ButterKnife;

/**
 * Created by lizhihui on 3/17/16.
 *
 */
public class MineFragment extends BaseFragment{

    @Inject
    public MineFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View fragmentView = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }
}
