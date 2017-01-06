package com.nan.acountclient.utils;

import android.text.TextUtils;
import android.util.Log;

import com.nan.acountclient.config.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static b.focused.w;
import static com.nan.acountclient.config.Config.LOGLEVEL;

/**
 * Created by wzn on 2016/9/12.
 */
public class Logger {

    public static final String DEFAULT_TAG = "account_Logger";

    private static int WARN = 0;


    public static void w(String tag, String msg) {
        if (Config.LOGLEVEL > WARN && !TextUtils.isEmpty(msg)) {
            if (TextUtils.isEmpty(tag)) tag = DEFAULT_TAG;
            {
                Log.w(tag, "==========================================================");
                StackTraceElement targetStackTraceElement = getTargetStackTraceElement();
                Log.w(tag, "(" + targetStackTraceElement.getFileName() + ":"
                        + targetStackTraceElement.getLineNumber() + ")");
                Log.w(tag, msg);
                Log.w(tag, "==========================================================");
            }
        }
    }

    public static void json(String jsonStr) {
        try {
            jsonStr = jsonStr.trim();
            if (jsonStr.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(jsonStr);
                w(DEFAULT_TAG, jsonObject.toString());
            }
            if (jsonStr.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(jsonStr);
                w(DEFAULT_TAG, jsonArray.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        w(DEFAULT_TAG, "Invalid Json, Please Check: " + jsonStr);
    }


    public static void w(String str) {
        w(DEFAULT_TAG, str);
    }


    public static void w(Number number) {
        w(DEFAULT_TAG, "Number is :" + String.valueOf(number));
    }

    private static StackTraceElement getTargetStackTraceElement() {
        // find the target invoked method
        StackTraceElement targetStackTrace = null;
        boolean shouldTrace = false;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            boolean isLogMethod = stackTraceElement.getClassName().equals(Logger.class.getName());
            if (shouldTrace && !isLogMethod) {
                targetStackTrace = stackTraceElement;
                break;
            }
            shouldTrace = isLogMethod;
        }
        return targetStackTrace;
    }


}
