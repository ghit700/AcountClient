package com.nan.acountclient.injector.module;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.nan.acountclient.injector.component.ActivityComponent;
import com.nan.acountclient.ui.BasePresenter;
import com.nan.acountclient.ui.BaseView;
import com.nan.acountclient.ui.login.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
