package com.nan.acountclient.injector.component;

import com.nan.acountclient.injector.PerActivity;
import com.nan.acountclient.injector.module.ActivityModule;
import com.nan.acountclient.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wzn on 2016/11/28.
 */
@PerActivity
@Component(dependencies = ApplicationComponet.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginActivity loginActivity);
}
