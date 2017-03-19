package com.nan.acountclient.components.app;

import android.app.Application;

import com.antfortune.freeline.FreelineCore;
import com.nan.acountclient.injector.component.ApplicationComponet;
import com.nan.acountclient.injector.component.DaggerApplicationComponet;
import com.nan.acountclient.injector.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by wzn on 2016/12/30.
 */

public class AccountApplication extends Application {
    /**
     * 注入器
     */
    ApplicationComponet mComponet;

    private static AccountApplication ins;

    public static AccountApplication getIns(){
        return ins;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        ins=this;
        FreelineCore.init(this);
        LeakCanary.install(this);
        mComponet = DaggerApplicationComponet.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponet getComponet(){
        return mComponet;
    }
}
