package com.nan.acountclient.data.remote.impl;

import com.alibaba.fastjson.JSONObject;
import com.nan.acountclient.components.retrofit.FastJsonConverterFactory;
import com.nan.acountclient.config.Config;
import com.nan.acountclient.data.remote.MainRemoteService;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.DataResult;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by wzn on 2017/1/5.
 */

public class MainRemoteServiceAPI {
    private Retrofit mRetrofit;
    private MainRemoteService mainRemoteService;

    @Inject
    public MainRemoteServiceAPI(OkHttpClient client) {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(client)
                .baseUrl(Config.BASE_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mainRemoteService = mRetrofit.create(MainRemoteService.class);
    }


    public Observable<DataResult<User>> login(String loginName, String pwd) {
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(pwd);
        return mainRemoteService.login(JSONObject.toJSONString(user)).subscribeOn(Schedulers.io());
    }

    public Observable<DataResult<User>>  register(User user) {
        return mainRemoteService.register(user).subscribeOn(Schedulers.io());
    }
}
