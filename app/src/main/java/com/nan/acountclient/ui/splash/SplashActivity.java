package com.nan.acountclient.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nan.acountclient.R;
import com.nan.acountclient.ui.login.LoginActivity;
import com.nan.acountclient.utils.AppUtils;

/**
 * Created by wzn on 2016/12/25.
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AppUtils.start(SplashActivity.this, LoginActivity.class);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
