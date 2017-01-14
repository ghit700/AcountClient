package com.nan.acountclient.ui.register;

import android.support.annotation.NonNull;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.ErrorData;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.UserData;
import com.nan.acountclient.ui.BaseView;
import com.nan.acountclient.ui.login.LoginContract;
import com.nan.acountclient.utils.Logger;
import com.nan.acountclient.utils.ToastUtils;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

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
