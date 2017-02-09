package com.nan.acountclient.ui.register;

import com.nan.acountclient.base.BasePresenter;
import com.nan.acountclient.base.BaseView;
import com.nan.acountclient.ui.login.LoginContract;

import static com.nan.acountclient.R.string.pwd;

/**
 * Created by wzn on 2017/1/6.
 */

public interface RegisterContract {
    interface View extends BaseView {
        void showLoading();

        void hideLoading();

        void registerSuccess();

        void registerFail(String err);
    }

    interface Presenter extends BasePresenter<View> {
        void register(String loginName ,String pwd);
    }
}
