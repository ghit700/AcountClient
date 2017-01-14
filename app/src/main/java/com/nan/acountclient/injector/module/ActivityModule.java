package com.nan.acountclient.injector.module;

import android.app.Activity;

import com.nan.acountclient.ui.BaseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wzn on 2016/11/28.
 */
@Module
public class ActivityModule {
    private final Activity activity;
    private final BaseView mView;

    public ActivityModule(Activity activity, BaseView view) {
        this.activity = activity;
        this.mView = view;
    }

    @Provides
    public BaseView provideView() {
        return mView;
    }

    @Provides
    public Activity provideActivity() {
        return activity;
    }


}
