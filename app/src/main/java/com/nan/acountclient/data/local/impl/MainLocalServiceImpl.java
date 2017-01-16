package com.nan.acountclient.data.local.impl;

import android.content.Context;

import com.nan.acountclient.components.db.Db;
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

    private Db db;
    private Context mContext;

    @Inject
    public MainLocalServiceImpl(Db db, Context context) {
        this.db = db;
        this.mContext = context;
    }

    @Override
    public void login(User user) {
        db.save(user);
        SettingPrefUtils.setLoginUid(mContext, user.getId());
    }

    @Override
    public void logout(User user) {
        User tempUser = new User();
        tempUser.setId(user.getId());
        tempUser.setName(user.getLoginName());
        db.updateById(tempUser, user.getId());
    }
}
