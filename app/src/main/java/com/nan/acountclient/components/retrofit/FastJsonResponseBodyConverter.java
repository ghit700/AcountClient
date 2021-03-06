package com.nan.acountclient.components.retrofit;

import com.alibaba.fastjson.JSON;
import com.nan.acountclient.utils.Logger;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by wzn on 2017/1/6.
 */

public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private Type type;
    private Charset charset;

    public FastJsonResponseBodyConverter() {
    }

    public FastJsonResponseBodyConverter(Type type, Charset charset) {
        this.type = type;
        this.charset = charset;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return JSON.parseObject(value.string(), type);
    }

}
