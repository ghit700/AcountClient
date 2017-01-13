package com.nan.acountclient.injector.module;

import android.app.Activity;
import dagger.Module;

/**
 * Created by wzn on 2016/11/28.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule( Activity activity) {
        this.activity = activity;
    }



}
