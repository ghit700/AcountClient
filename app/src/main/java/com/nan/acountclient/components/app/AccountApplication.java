package com.nan.acountclient.components.app;

import android.app.Application;

import com.antfortune.freeline.FreelineCore;
import com.nan.acountclient.injector.component.ApplicationComponet;
import com.nan.acountclient.injector.component.DaggerApplicationComponet;
import com.nan.acountclient.injector.module.ApplicationModule;
import com.nan.acountclient.utils.ToastUtils;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by wzn on 2016/12/30.
 */

public class AccountApplication extends Application {
    /**
     * 注入器
     */
    ApplicationComponet mComponet;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        ToastUtils.register(this);
        FreelineCore.init(this);
        LeakCanary.install(this);
        mComponet = DaggerApplicationComponet.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        ToastUtils.register(this);
    }

    public ApplicationComponet getComponet(){
        return mComponet;
    }
}
