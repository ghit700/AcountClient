package com.nan.acountclient.data.local.impl;

import android.content.Context;

import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.entity.User;
import com.nan.acountclient.utils.SettingPrefUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by wzn on 2017/1/5.
 */

public class MainLocalServiceImpl implements MainLocalService {

    private Context mContext;

    @Inject
    public MainLocalServiceImpl( Context context) {
        this.mContext = context;
    }

    @Override
    public void login(User user) {
        SettingPrefUtils.setLoginUid(mContext, user.getId());
    }

    @Override
    public void logout(User user) {

    }
}
