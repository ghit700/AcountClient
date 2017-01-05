package com.nan.acountclient.data.local;

import com.nan.acountclient.entity.User;

/**
 * 基本服务的本地服务类（如登陆，注册等）
 * Created by wzn on 2017/1/5.
 */
public interface MainLocalService {
    /**
     * 登陆
     * @param user
     */
     void login(User user);

    /**
     * 登出
     * @param user
     */
     void logout(User user);
}
