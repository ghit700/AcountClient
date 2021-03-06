package com.nan.acountclient.injector.component;

import android.content.Context;

import com.nan.acountclient.injector.PerActivity;
import com.nan.acountclient.injector.module.ActivityModule;
import com.nan.acountclient.ui.add.AddAccountActivity;
import com.nan.acountclient.ui.login.LoginActivity;
import com.nan.acountclient.ui.main.MainActivity;
import com.nan.acountclient.ui.register.RegisterActivity;
import com.nan.acountclient.ui.splash.SplashActivity;


import dagger.Component;

/**
 * Created by wzn on 2016/11/28.
 */
@PerActivity
@Component(dependencies = ApplicationComponet.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Context getContext();

    void inject(RegisterActivity registerActivity);

    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
    void inject(AddAccountActivity addAccountActivity);
    void inject(SplashActivity splashActivity);
}
