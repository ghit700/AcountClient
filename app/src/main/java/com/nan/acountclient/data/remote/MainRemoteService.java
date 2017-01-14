package com.nan.acountclient.data.remote;


import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.UserData;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wzn on 2017/1/5.
 */

public interface MainRemoteService {
    /**
     * 登陆
     * @param where
     * @return
     */
    @GET("user")
    Observable<UserData> login(@Query("where")String where);

    /**
     * 注册
     * @return
     */
    @POST("user")
    Observable<UserData> register(@Body User user);

}
