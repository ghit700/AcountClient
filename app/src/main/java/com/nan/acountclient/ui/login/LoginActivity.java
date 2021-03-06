package com.nan.acountclient.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;

import com.nan.acountclient.R;
import com.nan.acountclient.base.BaseActivity;
import com.nan.acountclient.components.rx.RxBus;
import com.nan.acountclient.event.RegisterEvent;
import com.nan.acountclient.entity.data.ErrorData;
import com.nan.acountclient.ui.main.MainActivity;
import com.nan.acountclient.ui.register.RegisterActivity;
import com.nan.acountclient.utils.AppUtils;
import com.nan.acountclient.utils.SnackbarUtils;
import com.nan.acountclient.utils.ToastUtils;
import com.tapadoo.alerter.Alert;
import com.tapadoo.alerter.Alerter;


import butterknife.InjectView;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


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
    private Alert mAlert;


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
        //注册功能回调
        addSubscribe(
                RxBus.getDefault().toObservable(RegisterEvent.class)
                        .subscribe(new Action1<RegisterEvent>() {
                            @Override
                            public void call(RegisterEvent registerEvent) {
                                etLoginName.setText(registerEvent.getLoginName());
                                etPwd.setText("");
                            }
                        }));
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
        AppUtils.closeInputMethodManager((Activity) mContext);
    }

    @Override
    public void showLoading() {
        mAlert= Alerter.create(this)
                .setText(R.string.login_progress_hirt)
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
        Snackbar.make(rootView, errorData.getError(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        SnackbarUtils.show(rootView,R.string.login_success);
        to(MainActivity.class, new Intent());
        finish();
    }



}
