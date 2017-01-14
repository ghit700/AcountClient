package com.nan.acountclient.ui.register;

import android.support.annotation.NonNull;

import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.UserData;
import com.nan.acountclient.ui.BaseView;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by wzn on 2017/1/6.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View mView;
    private MainRemoteServiceAPI remoteServiceAPI;

    @Inject
    public RegisterPresenter(MainRemoteServiceAPI remoteService) {
        this.remoteServiceAPI = remoteService;
    }

    @Inject
    @Override
    public void attachView(@NonNull BaseView view) {
        mView = (RegisterContract.View) view;
    }

    @Override
    public void detachView() {
        mView = null;
    }


    @Override
    public void register(User user) {
        mView.showLoading();
        remoteServiceAPI.register(user).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<UserData>() {
            @Override
            public void call(UserData userData) {
                mView.registerSuccess();
            }
        }, new ErrorAction() {
            @Override
            public void call(String msg) {
                mView.registerFail(msg);
            }
        });
    }
}
