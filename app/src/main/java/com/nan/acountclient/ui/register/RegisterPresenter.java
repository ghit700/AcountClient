package com.nan.acountclient.ui.register;

import android.content.Context;
import android.icu.math.MathContext;
import android.support.annotation.NonNull;

import com.nan.acountclient.R;
import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.components.rx.RxPresenter;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.DataResult;
import com.nan.acountclient.base.BaseView;
import com.nan.acountclient.entity.data.ErrorData;
import com.nan.acountclient.utils.StringUtils;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

import static com.nan.acountclient.utils.ToastUtils.mContext;

/**
 * Created by wzn on 2017/1/6.
 */

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter {
    private MainRemoteServiceAPI remoteServiceAPI;
    private Context mContext;
    @Inject
    public RegisterPresenter(MainRemoteServiceAPI remoteService,Context context) {
        this.remoteServiceAPI = remoteService;
        mContext=context;
    }

    @Override
    public void register(String loginName, String pwd) {
        if (StringUtils.isNullBlank(loginName)) {
            mView.registerFail("账号为空，请输入账号");
            return;
        }
        if (StringUtils.isNullBlank(pwd)) {
            mView.registerFail("密码为空，请输入密码");
            return;
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(pwd);

        mView.showLoading();
        Subscription subscription=remoteServiceAPI.register(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DataResult>() {
                    @Override
                    public void call(DataResult userData) {
                        mView.hideLoading();
                        mView.registerSuccess();
                    }
                }, new ErrorAction() {
                    @Override
                    public void call(ErrorData errorData) {
                        mView.hideLoading();
                        if(errorData.getCode()==401){

                            mView.registerFail(mContext.getString(R.string.exits_same_account));
                        }else{
                            mView.registerFail(errorData.getError());
                        }
                    }
                });
        addSubscribe(subscription);
    }
}
