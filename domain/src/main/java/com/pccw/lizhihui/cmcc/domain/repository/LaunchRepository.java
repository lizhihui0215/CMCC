package com.pccw.lizhihui.cmcc.domain.repository;

import com.pccw.lizhihui.cmcc.domain.LaunchOption;
import rx.Observable;

/**
 * Created by lizhihui on 4/16/16.
 */
public interface LaunchRepository {
    Observable<LaunchOption> launchOption();
}
