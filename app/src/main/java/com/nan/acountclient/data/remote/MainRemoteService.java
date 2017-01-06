package com.nan.acountclient.data.remote;


import com.nan.acountclient.entity.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wzn on 2017/1/5.
 */

public interface MainRemoteService {
    /**
     * 登陆
     * @param loginName
     * @param pwd
     * @return
     */
    @GET("/user")
    Observable<User> login(String loginName,String pwd);

    /**
     * 注册
     * @return
     */
    @POST("/user")
    Observable<User> register(@Body User user);

}
