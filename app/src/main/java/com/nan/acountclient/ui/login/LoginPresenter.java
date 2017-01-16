package com.nan.acountclient.ui.login;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.DataResult;
import com.nan.acountclient.ui.BaseView;
import com.nan.acountclient.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by wzn on 2017/1/6.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mLoginView;
    private MainLocalService localService;
    private MainRemoteServiceAPI remoteServiceAPI;

    @Inject
    public LoginPresenter(MainLocalService localService, MainRemoteServiceAPI remoteService) {
        this.localService = localService;
        this.remoteServiceAPI = remoteService;
    }

    @Inject
    @Override
    public void attachView(@NonNull BaseView view) {
        mLoginView = (LoginContract.View) view;
    }

    @Override
    public void detachView() {
        mLoginView = null;
    }

    @Override
    public void login(String loginName, String pwd) {
        if (StringUtils.isNullBlank(loginName)) {
            mLoginView.loginFail("账号为空，请输入");
            return;
        }
        if (StringUtils.isNullBlank(pwd)) {
            mLoginView.loginFail("密码为空，请输入");
            return;
        }
        mLoginView.showLoading();
        remoteServiceAPI.login(loginName, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DataResult>() {
                    @Override
                    public void call(DataResult userData) {
                        List<User> lstUsers = userData.results;
                        mLoginView.hideLoading();
                        if (lstUsers != null && lstUsers.size() > 0) {
                            User user = lstUsers.get(0);
                            localService.login(user);
                        } else {
                            mLoginView.loginFail("登陆失败，账号或密码错误。");
                        }
                    }
                }, new ErrorAction() {
                    @Override
                    public void call(String msg) {
                        mLoginView.hideLoading();
                        mLoginView.loginFail(msg);
                    }
                });
    }


}
