package com.pccw.lizhihui.cmcc.internal.di.components;

import android.app.Activity;

import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import com.pccw.lizhihui.cmcc.internal.di.modules.ActivityMoudle;

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
@Component(dependencies = ApplicationComponent.class, modules = ActivityMoudle.class)
public interface ActivityComponent {
    // Exposed to sub-graphs.
    Activity activity();
}
