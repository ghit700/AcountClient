package com.nan.acountclient.ui.register;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.nan.acountclient.R;
import com.nan.acountclient.entity.data.ErrorData;
import com.nan.acountclient.injector.component.DaggerActivityComponent;
import com.nan.acountclient.injector.module.ActivityModule;
import com.nan.acountclient.base.BaseActivity;
import com.nan.acountclient.utils.AppUtils;
import com.tapadoo.alerter.Alert;
import com.tapadoo.alerter.Alerter;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wzn on 2017/1/6.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {
    @InjectView(R.id.etRegisterLoginName)
    TextInputEditText etRegisterLoginName;
    @InjectView(R.id.etRegisterPwd)
    TextInputEditText etRegisterPwd;
    @InjectView(R.id.btnRegister)
    Button btnRegister;

    @InjectView(R.id.rootView)
    CoordinatorLayout rootView;
    private Alert mAlert;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
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
        getActivityComponent().inject(this);
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
        mAlert= Alerter.create(this)
                .setText(R.string.register_progress_hirt)
                .setBackgroundColor(R.color.colorPrimary)
                .show();
    }

    @Override
    public void hideLoading() {
        if(mAlert!=null){
            mAlert.hide();
        }
    }

    @Override
    public void showError(ErrorData errorData) {
        if (errorData.getError().contains("账号")) {
            etRegisterLoginName.setError(errorData.getError());
        } else if (errorData.getError().contains("密码")) {
            etRegisterPwd.setError(errorData.getError());
        }
        Snackbar.make(rootView, errorData.getError(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void registerSuccess() {
        Snackbar.make(rootView, getString(R.string.register_success), Snackbar.LENGTH_LONG).show();
    }




}
