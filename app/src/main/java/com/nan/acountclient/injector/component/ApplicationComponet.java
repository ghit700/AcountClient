package com.nan.acountclient.injector.component;


import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.injector.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by wzn on 2016/11/28.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponet {

    MainLocalService getMainLocalService();

    MainRemoteServiceAPI getMainRemoteServiceAPI();

}
