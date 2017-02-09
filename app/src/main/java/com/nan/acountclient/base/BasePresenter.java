package com.nan.acountclient.base;

import android.support.annotation.NonNull;

/**
 * Created by wzn on 2017/1/6.
 */

public interface BasePresenter<T extends BaseView> {


    void attachView(@NonNull T view);

    void detachView();
}
