package com.nan.acountclient.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.nan.acountclient.ui.login.LoginActivity;
import com.nan.acountclient.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wzn on 2016/12/12.
 */

public abstract class BaseActivity extends AppCompatActivity {

    List<Activity> mLstActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayout();
        init();
        initIntent();
        initData();
        initView();
        loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppUtils.remove(this);
    }

    public void init(){
        setStatusBar();
        initComponent();
        AppUtils.add(this);
    }

    protected abstract void getLayout();

    protected abstract void initIntent();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void loadData();

    /**
     * 沉浸状态栏
     */
    private  void setStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            //window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * 初始化注入器
     */
    protected void initComponent(){

    }

}
