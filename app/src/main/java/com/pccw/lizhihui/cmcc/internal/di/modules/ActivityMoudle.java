package com.pccw.lizhihui.cmcc.internal.di.modules;

import android.app.Activity;
import com.pccw.lizhihui.cmcc.internal.di.PerActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by lizhihui on 3/17/16.
 *
 * A moudle to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityMoudle {
    private final Activity activity;

    public ActivityMoudle(Activity activity){ this.activity = activity; }

    @Provides @PerActivity Activity activity(){ return this.activity; }

}
