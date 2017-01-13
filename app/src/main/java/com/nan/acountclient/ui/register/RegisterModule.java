package com.nan.acountclient.ui.register;

import com.nan.acountclient.ui.login.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wzn on 2017/1/9.
 */
@Module
public class RegisterModule {

    private final RegisterContract.View mView;

    public RegisterModule(RegisterContract.View mView) {
        this.mView = mView;
    }

    @Provides
    RegisterContract.View provideRegisterContractView() {
        return mView;
    }
}
