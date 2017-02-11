package com.nan.acountclient.ui.main;

import com.nan.acountclient.base.BasePresenter;
import com.nan.acountclient.base.BaseView;

/**
 * Created by wzn on 2017/1/6.
 */

public interface MainContract {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
