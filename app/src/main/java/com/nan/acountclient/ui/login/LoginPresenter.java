package com.nan.acountclient.ui.login;

import android.support.annotation.NonNull;

import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.MainRemoteService;

import javax.inject.Inject;

/**
 * Created by wzn on 2017/1/6.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mLoginView;
    private MainLocalService localService;
    private MainRemoteService remoteService;

    @Inject
    public LoginPresenter(MainLocalService localService, MainRemoteService remoteService) {
        this.localService = localService;
        this.remoteService = remoteService;
    }

    @Override
    public void attachView(@NonNull LoginContract.View view) {
        mLoginView = view;
    }

    @Override
    public void detachView() {
        mLoginView=null;
    }

    @Override
    public void login(String loginName, String pwd) {
        remoteService.login(loginName,pwd);
    }
}
