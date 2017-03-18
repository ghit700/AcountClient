package com.nan.acountclient.base;

import com.nan.acountclient.entity.data.ErrorData;

/**
 * Created by wzn on 2017/1/6.
 */

public interface BaseView {
    void showLoading();

    void hideLoading();

    void showError(ErrorData errorData);
}
