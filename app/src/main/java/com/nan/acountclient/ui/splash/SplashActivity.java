package com.nan.acountclient.ui.splash;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.nan.acountclient.ui.BaseActivity;
import com.nan.acountclient.ui.login.LoginActivity;
import com.nan.acountclient.utils.AppUtils;

/**
 * Created by wzn on 2016/12/25.
 */

public class SplashActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        
        AppUtils.start(this, LoginActivity.class);
    }
}
