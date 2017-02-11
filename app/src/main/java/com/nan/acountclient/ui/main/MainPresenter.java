package com.nan.acountclient.ui.main;


import com.nan.acountclient.components.retrofit.ErrorAction;
import com.nan.acountclient.components.rx.RxPresenter;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.entity.data.DataResult;
import com.nan.acountclient.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


/**
 * Created by wzn on 2017/1/6.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    @Inject
    public MainPresenter() {

    }
    




}
