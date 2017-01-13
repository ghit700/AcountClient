package com.nan.acountclient.ui.login;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wzn on 2017/1/9.
 */
@Module
public class LoginModule {

    private final LoginContract.View mView;

    public LoginModule(LoginContract.View mView) {
        this.mView = mView;
    }

    @Provides
    LoginContract.View provideLoginContrackView(){
        return mView;
    }
}
