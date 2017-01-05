package com.nan.acountclient.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by wzn on 2017/1/5.
 */

public class SettingPrefUtils {
    public static void setLoginUid(Context context,Long uid){
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putLong("loginUid",uid).apply();
    }

}
