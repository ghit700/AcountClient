package com.nan.acountclient.injector.component;


import com.nan.acountclient.components.app.AccountApplication;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.MainRemoteService;
import com.nan.acountclient.injector.module.ApplicationModule;
import com.nan.acountclient.ui.BaseActivity;
import com.nan.acountclient.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wzn on 2016/11/28.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponet {
    MainLocalService provideMainLocalService();

    MainRemoteService provideMainRemoteService();

    void inject(AccountApplication application);
    void inject(BaseActivity baseActivity);
}
