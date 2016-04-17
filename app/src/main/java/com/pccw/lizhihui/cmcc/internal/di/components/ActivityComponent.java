package com.pccw.lizhihui.cmcc.internal.di.components;

import android.support.v7.app.AppCompatActivity;
import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityModule;
import com.pccw.lizhihui.cmcc.view.activity.MainActivity;

import dagger.Component;

/**
 * Created by lizhihui on 3/18/16.
 *
 * A base component upon which fragment's components may dpend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation
 * {@link com.pccw.lizhihui.cmcc.internal.di.PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    // Exposed to sub-graphs.
    AppCompatActivity activity();

}
