package com.nan.acountclient.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by wzn on 2017/1/5.
 */

public class SettingPrefUtils {
    /**
     * 设置登陆
     * @param context
     * @param uid
     */
    public static void setLoginUid(Context context,Long uid){
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putLong("loginUid",uid).apply();
    }

    /**
     * 清除登陆
     * @param context
     */
    public static void clearLogin(Context context){
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().remove("loginUid").apply();
    }

    /**
     * 设置网络状态
     * @param context
     * @param isOffLine
     */
    public static void setOffLine(Context context,boolean isOffLine){
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean("offLine",isOffLine).apply();
    }

    /**
     * 获取网络状态
     * @param context
     */
    public static void getOffLine(Context context){
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
        prefs.getBoolean("offLine",false);
    }

}
