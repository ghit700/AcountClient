package com.nan.acountclient.entity.data;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * Created by wzn on 2017/1/14.
 */

public class ErrorData {


    /**
     * code : 401
     * error : unique index cannot has duplicate value:
     */

    private int code;
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ErrorData handleError(Throwable throwable) {
        ErrorData errorData = new ErrorData();
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            try {
                errorData = JSONObject.parseObject(httpException.response().errorBody().string(), ErrorData.class);
            } catch (IOException e) {
                e.printStackTrace();
                errorData.setError(e.getMessage());
            }
        } else {

            errorData.setError(throwable.getMessage());
            return errorData;
        }
        return errorData;
    }
}
