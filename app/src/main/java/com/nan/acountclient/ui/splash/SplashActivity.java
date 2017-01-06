package com.nan.acountclient.ui.splash;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nan.acountclient.R;
import com.nan.acountclient.ui.BaseActivity;
import com.nan.acountclient.ui.login.LoginActivity;
import com.nan.acountclient.utils.AppUtils;
import com.nan.acountclient.utils.Logger;

/**
 * Created by wzn on 2016/12/25.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_splash);
        AppUtils.start(this, LoginActivity.class);
    }
}
