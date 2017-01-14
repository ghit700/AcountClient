package com.nan.acountclient.components.retrofit;

import com.nan.acountclient.entity.data.ErrorData;

import rx.functions.Action1;

/**
 * Created by wzn on 2017/1/14.
 */

public abstract class ErrorAction implements Action1<Throwable> {
    @Override
    public void call(Throwable throwable) {
        ErrorData errorData = new ErrorData();
        errorData = errorData.handleError(throwable);
        call(errorData.getError());
    }

    public abstract void call(String msg);
}
