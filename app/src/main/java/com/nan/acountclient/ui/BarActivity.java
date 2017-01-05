package com.nan.acountclient.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.support.v7.widget.Toolbar;

import com.nan.acountclient.R;

/**
 * Created by wzn on 2016/12/25.
 */

public abstract class BarActivity extends BaseActivity {

    Toolbar tb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void getLayout() {
        setContentView(R.layout.activity_bar);
        ((FrameLayout)findViewById(R.id.content)).addView(getLayoutInflater().inflate(getLayoutId(),null));
        initBar();
    }
    protected abstract int getLayoutId();

    /**
     * 初始化bar
     */
    protected void initBar(){
        tb= (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(setBarTitle());
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    protected abstract String setBarTitle();
}
