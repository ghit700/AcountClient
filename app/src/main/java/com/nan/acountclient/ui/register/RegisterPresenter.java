package com.nan.acountclient.ui.register;

import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.UserData;
import com.nan.acountclient.ui.login.LoginContract;
import com.nan.acountclient.utils.Logger;

import java.util.List;

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
    public void attachView(@NonNull RegisterContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }


    @Override
    public void register(User user) {
        remoteServiceAPI.register(user)
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {
                        Logger.w(JSONObject.toJSONString(user));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }
}
