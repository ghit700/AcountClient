package com.nan.acountclient.data.remote.impl;

import com.nan.acountclient.components.retrofit.FastJsonConverterFactory;
import com.nan.acountclient.config.Config;
import com.nan.acountclient.data.remote.MainRemoteService;
import com.nan.acountclient.entity.User;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by wzn on 2017/1/5.
 */

public class MainRemoteServiceImpl implements MainRemoteService {
    private Retrofit mRetrofit;
    private MainRemoteService mainRemoteService;

    @Inject
    public MainRemoteServiceImpl(OkHttpClient client) {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(client)
                .baseUrl(Config.BASE_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mainRemoteService = mRetrofit.create(MainRemoteService.class);
    }


    @Override
    public Observable<User> login(String loginName, String pwd) {
        return mainRemoteService.login(loginName, pwd).subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<User> register(User user) {
        return mainRemoteService.register(user).subscribeOn(Schedulers.io());
    }
}
