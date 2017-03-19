package com.nan.acountclient.utils;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.nan.acountclient.components.app.AccountApplication;

/**
 * Created by wzn on 2017/3/12.
 */

public class SnackbarUtils {
    public static void show(View view, int resId) {
        Snackbar.make(view, AccountApplication.getIns().getString(resId), Snackbar.LENGTH_LONG).show();
    }

    public static void show(View view,String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }
}
