package com.nan.acountclient.ui.register;

import com.nan.acountclient.injector.PerActivity;
import com.nan.acountclient.injector.component.ApplicationComponet;
import com.nan.acountclient.ui.login.LoginActivity;
import com.nan.acountclient.ui.login.LoginModule;

import dagger.Component;

/**
 * Created by wzn on 2017/1/9.
 */
@PerActivity
@Component(dependencies = ApplicationComponet.class,modules = RegisterModule.class)
public interface RegisterComponent {
    void inject(RegisterActivity registerActivity);
}
