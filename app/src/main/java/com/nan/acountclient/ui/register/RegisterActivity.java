package com.nan.acountclient.ui.register;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.nan.acountclient.R;
import com.nan.acountclient.injector.component.DaggerActivityComponent;
import com.nan.acountclient.injector.module.ActivityModule;
import com.nan.acountclient.ui.BaseActivity;
import com.nan.acountclient.utils.AppUtils;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wzn on 2017/1/6.
 */

public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    @InjectView(R.id.etRegisterLoginName)
    TextInputEditText etRegisterLoginName;
    @InjectView(R.id.etRegisterPwd)
    TextInputEditText etRegisterPwd;
    @InjectView(R.id.btnRegister)
    Button btnRegister;
    @Inject
    RegisterPresenter mPresenter;
    @InjectView(R.id.rootView)
    CoordinatorLayout rootView;

    @Override
    protected void getLayout() {
        setContentView(R.layout.activity_register);
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

    @Override
    protected void initComponent() {
        DaggerActivityComponent.builder()
                .applicationComponet(getApplicationComponent())
                .activityModule(new ActivityModule(this, this))
                .build()
                .inject(this);
    }


    @OnClick(R.id.btnRegister)
    public void onClick() {
        AppUtils.closeInputMethodManager(this);
        String pwd = etRegisterPwd.getText().toString();
        String loginName = etRegisterLoginName.getText().toString();
        mPresenter.register(loginName, pwd);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void registerSuccess() {

    }

    @Override
    public void registerFail(String err) {
        if (err.contains("账号")) {
            etRegisterLoginName.setError(err);
        } else if (err.contains("密码")) {
            etRegisterPwd.setError(err);
        }
        Snackbar.make(rootView, err, Snackbar.LENGTH_LONG).show();

    }


}
