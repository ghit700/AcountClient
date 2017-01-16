package com.nan.acountclient.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzn on 2017/1/5.
 */

public class AppUtils {
    public  static List<Activity> lstAcititys=new ArrayList<>();

    public static void add(Activity activity){
     lstAcititys.add(activity);
    }

    public static void remove(Activity activity){
        lstAcititys.remove(activity);
    }

    public static void removeAll(){
        int length=lstAcititys.size();
        for(int i=0;i<length;i++){
            lstAcititys.remove(i);
        }
    }

    public static  void start(Context context, Class clazz){
        Intent intent=new Intent();
        intent.setClass(context, clazz);
        context.startActivity(intent);
    }
    public static  void start(Context context,Class clazz,Bundle bundle){
        Intent intent=new Intent();
        intent.setClass(context, clazz);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 判断网络是否链接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager cwjManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = cwjManager.getActiveNetworkInfo();
            if (mNetworkInfo == null || !mNetworkInfo.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 关闭软键盘
     *
     * @param activity
     */
    public static void closeInputMethodManager(Activity activity) {
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            imm = null;
            view = null;
        }
    }
}
