package com.nan.acountclient.ui.login;

import com.nan.acountclient.injector.PerActivity;
import com.nan.acountclient.injector.component.ApplicationComponet;


import dagger.Component;

/**
 * Created by wzn on 2017/1/9.
 */
@PerActivity
@Component(dependencies = ApplicationComponet.class,modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
