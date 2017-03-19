package com.nan.acountclient.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.nan.acountclient.components.app.AccountApplication;

/**
 * Created by wzn on 2017/1/5.
 */

public class SettingPrefUtils {
    /**
     * 设置登陆
     *
     * @param uid
     */
    public static void setLoginUid(int uid) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AccountApplication.getIns());
        prefs.edit().putInt("loginUid", uid).apply();
    }

    public static int getLoginUid(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AccountApplication.getIns());
        return prefs.getInt("loginUid",0);
    }

    /**
     * 清除登陆
     */
    public static void clearLogin() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AccountApplication.getIns());
        prefs.edit().remove("loginUid").apply();
    }

    /**
     * 设置网络状态
     *
     * @param isOffLine
     */
    public static void setOffLine(boolean isOffLine) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AccountApplication.getIns());
        prefs.edit().putBoolean("offLine", isOffLine).apply();
    }

    /**
     * 获取网络状态
     */
    public static void getOffLine() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(AccountApplication.getIns());
        prefs.getBoolean("offLine", false);
    }

}
