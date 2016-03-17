package com.pccw.lizhihui.cmcc.internal.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lizhihui on 3/17/16.
 *
 * A scoping annotation to permit objects whose lifetime should
 * comform to the life of the activity to be memorized in th
 * correct component.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
