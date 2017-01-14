package com.nan.acountclient.ui.register;

import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.nan.acountclient.R;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.injector.component.DaggerActivityComponent;
import com.nan.acountclient.injector.module.ActivityModule;
import com.nan.acountclient.ui.BaseActivity;
import com.nan.acountclient.utils.ToastUtils;

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
                .activityModule(new ActivityModule(this,this))
                .build()
                .inject(this);
    }


    @OnClick(R.id.btnRegister)
    public void onClick() {
        String pwd=etRegisterPwd.getText().toString();
        String loginName=etRegisterLoginName.getText().toString();
        User user=new User();
        user.setPassword(pwd);
        user.setLoginName(loginName);
        mPresenter.register(user);
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
        ToastUtils.showToast(err);
    }
}
