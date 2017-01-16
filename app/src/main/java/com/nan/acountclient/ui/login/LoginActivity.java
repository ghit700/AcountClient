package com.nan.acountclient.ui.login;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.nan.acountclient.R;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.injector.component.DaggerActivityComponent;
import com.nan.acountclient.injector.module.ActivityModule;
import com.nan.acountclient.ui.BaseActivity;
import com.nan.acountclient.ui.register.RegisterActivity;
import com.nan.acountclient.utils.AppUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by wzn on 2016/12/25.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @InjectView(R.id.etLoginName)
    TextInputEditText etLoginName;
    @InjectView(R.id.etPwd)
    TextInputEditText etPwd;
    @InjectView(R.id.btnLoginSubmit)
    Button btnLoginSubmit;
    @InjectView(R.id.btnLoginRegister)
    Button btnLoginRegister;

    @Inject
    LoginPresenter mPresenter;
    @InjectView(R.id.rootView)
    CoordinatorLayout rootView;


    @Override
    protected void getLayout() {
        setContentView(R.layout.activity_login);

    }

    @Override
    protected void initComponent() {
        DaggerActivityComponent.builder()
                .applicationComponet(getApplicationComponent())
                .activityModule(new ActivityModule(this, this))
                .build()
                .inject(this);
    }

    @Override
    protected void initIntent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.btnLoginSubmit, R.id.btnLoginRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoginSubmit:
                mPresenter.login(etLoginName.getText().toString(), etPwd.getText().toString());
                break;
            case R.id.btnLoginRegister:
                AppUtils.start(this, RegisterActivity.class);
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFail(String err) {
        Snackbar.make(rootView,err,Snackbar.LENGTH_LONG).show();
    }


}
