package com.nan.acountclient.ui.add;


import com.alibaba.fastjson.JSON;
import com.nan.acountclient.components.okhttp.HttpLoggingInterceptor;
import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.components.rx.RxPresenter;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.Bill;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.DataResult;
import com.nan.acountclient.entity.data.ErrorData;
import com.nan.acountclient.utils.Logger;
import com.nan.acountclient.utils.ToastUtils;

import javax.inject.Inject;

import cn.bmob.push.lib.util.LogUtil;
import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by wzn on 2017/3/5.
 */

public class AddAccountPresenter extends RxPresenter<AddAccountContract.View> implements AddAccountContract.Presenter {
    private MainLocalService localService;
    private MainRemoteServiceAPI remoteServiceAPI;

    @Inject
    public AddAccountPresenter(MainLocalService localService, MainRemoteServiceAPI remoteService) {
        this.localService = localService;
        this.remoteServiceAPI = remoteService;
    }

    @Override
    public void saveBill(double money, int tagId, String remark) {

        Subscription subscribe = localService.saveBill(money, tagId, remark)
                .flatMap(new Func1<Bill, Observable<DataResult<Bill>>>() {
                    @Override
                    public Observable<DataResult<Bill>> call(Bill bill) {
                        return remoteServiceAPI.saveBill(bill);
                    }
                })
                .map(new Func1<DataResult<Bill>, Bill>() {
                    @Override
                    public Bill call(DataResult<Bill> billDataResult) {
                        return billDataResult.results.get(0);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bill>() {
                    @Override
                    public void call(Bill bill) {
                        mView.saveSuccess(bill);
                    }
                }, new ErrorAction() {
                    @Override
                    public void call(ErrorData msg) {
//                        ToastUtils.showToast(msg);
                    }
                });
        addSubscribe(subscribe);
    }
}
