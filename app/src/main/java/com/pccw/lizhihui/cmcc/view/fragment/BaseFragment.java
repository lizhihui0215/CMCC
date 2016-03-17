package com.pccw.lizhihui.cmcc.view.fragment;

import android.support.v4.app.Fragment;

import android.widget.Toast;

import com.pccw.lizhihui.cmcc.internal.di.HasComponent;

/**
 * Created by lizhihui on 3/17/16.
 * Base {@link android.app.Fragment} class for every fragment in this application
 */
public class BaseFragment extends Fragment {

    /**
     * Shows a {@link android.widget.Toast} message.
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Get a component for dependency injection by its type.
     * @param componentType
     * @param <C>
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType){
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }



}
