package com.nan.acountclient.ui.login;

import com.nan.acountclient.entity.User;
import com.nan.acountclient.ui.BasePresenter;
import com.nan.acountclient.ui.BaseView;

/**
 * Created by wzn on 2017/1/6.
 */

public interface LoginContract {
    interface View extends BaseView {
        void showLoading();

        void hideLoading();

        void loginSuccess();

        void loginFail(String err);
    }

    interface Presenter extends BasePresenter {
        void login(String loginName, String pwd);
    }
}
