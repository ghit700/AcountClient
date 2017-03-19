package com.nan.acountclient.event;

/**
 * 注册事件
 * Created by wzn on 2017/2/26.
 */

public class RegisterEvent {
    private String loginName;

    public RegisterEvent() {
    }

    public RegisterEvent(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
