package com.nan.acountclient.utils;

import android.content.Context;
import android.widget.Toast;

import com.nan.acountclient.components.app.AccountApplication;

/**
 * Created by wzn on 2017/1/5.
 */

public class ToastUtils {


    public static void showToast(int resId) {
        Toast.makeText(AccountApplication.getIns(), AccountApplication.getIns().getString(resId), Toast.LENGTH_SHORT).show();
    }

    public static void showToast(String msg) {
        Toast.makeText(AccountApplication.getIns(), msg, Toast.LENGTH_SHORT).show();
    }
}
