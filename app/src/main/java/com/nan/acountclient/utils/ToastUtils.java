package com.nan.acountclient.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by wzn on 2017/1/5.
 */

public class ToastUtils {
    public static Context mContext;

    public static void register(Context context) {
        mContext = context.getApplicationContext();
    }

    public static void showToast(int resId) {
        Toast.makeText(mContext, mContext.getString(resId), Toast.LENGTH_SHORT).show();
    }

    public static void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
