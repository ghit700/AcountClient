package com.nan.acountclient.ui.register;

import com.nan.acountclient.entity.User;
import com.nan.acountclient.ui.BasePresenter;
import com.nan.acountclient.ui.BaseView;

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

    interface Presenter extends BasePresenter {
        void register(User user);
    }
}
