package com.nan.acountclient.ui.login;

import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSONArray;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.UserData;
import com.nan.acountclient.utils.Logger;

import org.apache.commons.logging.Log;

import java.io.Console;
import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
    public void attachView(@NonNull LoginContract.View view) {
        mLoginView = view;
    }

    @Override
    public void detachView() {
        mLoginView = null;
    }

    @Override
    public void login(String loginName, String pwd) {
        remoteServiceAPI.login(loginName, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserData>() {
                    @Override
                    public void call(UserData userData) {
                        List<User> lstUsers = userData.results;
                        Logger.w(JSONArray.toJSONString(lstUsers));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Logger.w(throwable.toString());
                    }
                });
    }


}
