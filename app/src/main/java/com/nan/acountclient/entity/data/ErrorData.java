package com.nan.acountclient.entity.data;

import android.widget.Switch;

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
                switch (errorData.code) {
                    case 401:
                        errorData.setError("唯一键不能存在重复的值");
                        break;
                    case 601:
                        errorData.setError("不正确的BQL查询语句");
                        break;
                    case 210:
                        errorData.setError("旧密码不正确");
                        break;
                    case 209:
                        errorData.setError("该手机号码已经存在");
                        break;
                    case 208:
                        errorData.setError("authData不正确或authData已经绑定了其他用户账户");
                        break;
                    case 207:
                        errorData.setError("验证码错误");
                        break;
                    case 160:
                    case 161:
                    case 162:
                    case 163:
                    case 164:
                    case 165:
                        errorData.setError("图片错误");
                        break;
                    case 150:
                        errorData.setError("文件上传错误");
                    case 151:
                        errorData.setError("文件删除错误");
                        break;
                }
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
