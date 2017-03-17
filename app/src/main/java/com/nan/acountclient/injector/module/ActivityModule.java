package com.nan.acountclient.injector.module;

import android.app.Activity;
import android.content.Context;

import com.nan.acountclient.base.BaseView;
import com.nan.acountclient.injector.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wzn on 2016/11/28.
 */
@Module
public class ActivityModule {
    public Context context;
    public ActivityModule(Context context) {
        this.context=context;
    }

    @PerActivity
    @Provides
    public Context provideContext(){
        return  context;
    }




}
