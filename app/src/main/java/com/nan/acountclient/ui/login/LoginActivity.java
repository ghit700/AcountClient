package com.nan.acountclient.ui.login;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.nan.acountclient.R;
import com.nan.acountclient.base.BaseActivity;
import com.nan.acountclient.ui.main.MainActivity;
import com.nan.acountclient.ui.register.RegisterActivity;


import butterknife.InjectView;
import butterknife.OnClick;


/**
 * Created by wzn on 2016/12/25.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @InjectView(R.id.etLoginName)
    TextInputEditText etLoginName;
    @InjectView(R.id.etPwd)
    TextInputEditText etPwd;
    @InjectView(R.id.btnLoginSubmit)
    Button btnLoginSubmit;
    @InjectView(R.id.btnLoginRegister)
    Button btnLoginRegister;


    @InjectView(R.id.rootView)
    CoordinatorLayout rootView;


    @Override
    protected int getLayout() {
        return R.layout.activity_login;

    }

    @Override
    protected void initComponent() {
        getActivityComponent().inject(this);
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
                to(RegisterActivity.class, new Intent());
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
        to(MainActivity.class, new Intent());
        finish();
    }

    @Override
    public void loginFail(String err) {
        Snackbar.make(rootView, err, Snackbar.LENGTH_LONG).show();
    }


}
