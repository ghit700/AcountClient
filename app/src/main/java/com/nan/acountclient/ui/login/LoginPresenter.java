package com.nan.acountclient.ui.login;


import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.components.rx.RxPresenter;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.DataResult;
import com.nan.acountclient.ui.login.LoginContract.View;
import com.nan.acountclient.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * Created by wzn on 2017/1/6.
 */

public class LoginPresenter extends RxPresenter<View> implements LoginContract.Presenter {
    private MainLocalService localService;
    private MainRemoteServiceAPI remoteServiceAPI;

    @Inject
    public LoginPresenter(MainLocalService localService, MainRemoteServiceAPI remoteService) {
        this.localService = localService;
        this.remoteServiceAPI = remoteService;
    }
    

    @Override
    public void login(String loginName, String pwd) {
        if (StringUtils.isNullBlank(loginName)) {
            mView.loginFail("账号为空，请输入");
            return;
        }
        if (StringUtils.isNullBlank(pwd)) {
            mView.loginFail("密码为空，请输入");
            return;
        }
        mView.showLoading();
        Subscription subscription=remoteServiceAPI.login(loginName, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DataResult>() {
                    @Override
                    public void call(DataResult userData) {
                        List<User> lstUsers = userData.results;
                        mView.hideLoading();
                        if (lstUsers != null && lstUsers.size() > 0) {
                            User user = lstUsers.get(0);
                            localService.login(user);
                            mView.loginSuccess();
                        } else {
                            mView.loginFail("登陆失败，账号或密码错误。");
                        }
                    }
                }, new ErrorAction() {
                    @Override
                    public void call(String msg) {
                        mView.hideLoading();
                        mView.loginFail(msg);
                    }
                });
        addSubscribe(subscription);
    }


}
