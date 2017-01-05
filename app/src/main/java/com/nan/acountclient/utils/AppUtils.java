package com.nan.acountclient.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

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
}
