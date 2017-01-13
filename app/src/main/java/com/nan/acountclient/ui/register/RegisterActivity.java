package com.nan.acountclient.ui.register;

import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.nan.acountclient.R;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.ui.BaseActivity;

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
        DaggerRegisterComponent.builder()
                .applicationComponet(getApplicationComponent())
                .registerModule(new RegisterModule(this))
                .build().inject(this);
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

    }
}
