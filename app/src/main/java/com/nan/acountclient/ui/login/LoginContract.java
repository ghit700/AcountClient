package com.nan.acountclient.ui.login;

import com.nan.acountclient.base.BasePresenter;
import com.nan.acountclient.base.BaseView;

/**
 * Created by wzn on 2017/1/6.
 */

public interface LoginContract {
    interface View extends BaseView {

        void loginSuccess();

    }

    interface Presenter extends BasePresenter<View> {
        void login(String loginName, String pwd);
    }
}
