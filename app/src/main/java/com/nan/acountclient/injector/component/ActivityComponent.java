package com.nan.acountclient.injector.component;

import com.nan.acountclient.injector.PerActivity;
import com.nan.acountclient.ui.login.LoginModule;


import dagger.Component;

/**
 * Created by wzn on 2016/11/28.
 */
@PerActivity
@Component(dependencies = ApplicationComponet.class, modules = LoginModule.class)
public interface ActivityComponent {
}
