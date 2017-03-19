package com.nan.acountclient.data.local.impl;

import android.content.Context;

import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.entity.Bill;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.utils.SettingPrefUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;

/**
 * Created by wzn on 2017/1/5.
 */

public class MainLocalServiceImpl implements MainLocalService {

    private Context mContext;
    private final Realm mRealm;

    @Inject
    public MainLocalServiceImpl(Context context, Realm mRealm) {
        this.mContext = context;
        this.mRealm = mRealm;
    }

    @Override
    public void login(User user) {
        if (mRealm.where(User.class).equalTo("id", user.getId()).findFirst() == null) {
            mRealm.beginTransaction();
            mRealm.copyToRealm(user);
            mRealm.commitTransaction();
        }
        SettingPrefUtils.setLoginUid(user.getId());
    }

    @Override
    public void logout(User user) {

    }

    @Override
    public User getUser() {
        int userId = SettingPrefUtils.getLoginUid();
        return mRealm.where(User.class).equalTo("id", userId).findFirst();
    }

    @Override
    public Observable<Bill> saveBill(double money, int tagId, String remark) {
        User user = getUser();
        final Bill bill = new Bill();
        bill.setCreator(user.getId());
        bill.setMoney(money);
        bill.setRemark(remark);
        bill.setType(0);
        bill.setTagId(tagId);
        mRealm.beginTransaction();
        bill.setId((int) mRealm.where(Bill.class).count());
        Observable<Bill> observable = mRealm.copyToRealm(bill).asObservable();
        mRealm.commitTransaction();
        return observable;
    }
}
