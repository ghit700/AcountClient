package com.nan.acountclient.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.nan.acountclient.utils.AppUtils;

import butterknife.ButterKnife;

import static com.nan.acountclient.R.id.tb;

/**
 * Created by wzn on 2017/2/9.
 * 比较简单的activity，无需mvp
 */

public abstract class SimpleActivity extends AppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
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

    public void init() {
        setStatusBar();
        AppUtils.add(this);
        ButterKnife.inject(this);
        mContext = this;
    }

    protected abstract int getLayout();

    protected abstract void initIntent();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void loadData();

    /**
     * 沉浸状态栏
     */
    private void setStatusBar() {
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

    protected void setToolBar(Toolbar toolBar, String title) {
        toolBar = (Toolbar) findViewById(tb);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(title);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void to(@NonNull final Class clazz, @NonNull final Intent intent) {
        intent.setClass(this, clazz);
        startActivity(intent);
    }

    public void toForResult(@NonNull final Class clazz, @NonNull final Intent intent, @NonNull int requestCode) {
        intent.setClass(this, clazz);
        startActivityForResult(intent, requestCode);
    }
}
