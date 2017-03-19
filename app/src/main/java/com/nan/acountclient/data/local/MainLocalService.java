package com.nan.acountclient.data.local;

import com.nan.acountclient.entity.Bill;
import com.nan.acountclient.entity.User;

import rx.Observable;

/**
 * 基本服务的本地服务类（如登陆，注册等）
 * Created by wzn on 2017/1/5.
 */
public interface MainLocalService {
    /**
     * 登陆
     *
     * @param user
     */
    void login(User user);

    /**
     * 登出
     */
    void logout(User user);

    /**
     * 获取当前登录用户信息
     */
    User getUser();

    Observable<Bill> saveBill(double money, int tagId, String remark);
}
