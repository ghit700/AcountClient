package com.nan.acountclient.components.okhttp;

import com.nan.acountclient.config.Config;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wzn on 2017/1/6.
 * 添加header拦截器
 */

public class HeaderInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original=chain.request();
        Request request=original.newBuilder()
                .addHeader("X-Bmob-Application-Id", Config.app_id)
                .addHeader("X-Bmob-REST-API-Key", Config.rest_api_key)
                .addHeader("Content-Type","application/json")
                .build();
        return chain.proceed(request);
    }
}
