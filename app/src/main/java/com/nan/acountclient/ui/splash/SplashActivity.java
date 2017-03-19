package com.nan.acountclient.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nan.acountclient.R;
import com.nan.acountclient.base.SimpleActivity;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.local.impl.MainLocalServiceImpl;
import com.nan.acountclient.data.remote.MainRemoteService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.ui.add.AddAccountActivity;
import com.nan.acountclient.ui.login.LoginActivity;
import com.nan.acountclient.ui.main.MainActivity;
import com.nan.acountclient.utils.AppUtils;
import com.nan.acountclient.utils.SettingPrefUtils;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by wzn on 2016/12/25.
 */

public class SplashActivity extends SimpleActivity {

    @Inject
    MainLocalService mainLocalService;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (SettingPrefUtils.getLoginUid() != 0 && mainLocalService.getUser()!=null) {
                                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            } else {
                                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                            }
                            finish();
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void initComponent() {
        getActivityComponent().inject(this);
    }


}
