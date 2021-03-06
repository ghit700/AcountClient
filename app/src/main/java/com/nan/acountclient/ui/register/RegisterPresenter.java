package com.nan.acountclient.ui.register;

import android.content.Context;

import com.nan.acountclient.R;
import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.components.rx.RxPresenter;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.DataResult;
import com.nan.acountclient.entity.data.ErrorData;
import com.nan.acountclient.utils.StringUtils;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * Created by wzn on 2017/1/6.
 */

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter {
    private MainRemoteServiceAPI remoteServiceAPI;
    @Inject
    Context mContext;
    @Inject
    public RegisterPresenter(MainRemoteServiceAPI remoteService) {
        this.remoteServiceAPI = remoteService;
    }

    @Override
    public void register(String loginName, String pwd) {
        if (StringUtils.isNullBlank(loginName)) {
            ErrorData errorData=new ErrorData();
            mView.showError(new ErrorData(mContext.getString(R.string.login_name_empty)));
            return;
        }
        if (StringUtils.isNullBlank(pwd)) {
            mView.showError(new ErrorData(mContext.getString(R.string.login_pwd_empty)));
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
                            errorData.setError(mContext.getString(R.string.exits_same_account));
                        }
                        mView.showError(errorData);

                    }
                });
        addSubscribe(subscription);
    }
}
