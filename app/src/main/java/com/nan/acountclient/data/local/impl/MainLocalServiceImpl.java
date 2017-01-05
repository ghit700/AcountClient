package com.nan.acountclient.data.local.impl;

import com.nan.acountclient.components.db.Db;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.entity.User;

import javax.inject.Inject;

/**
 * Created by wzn on 2017/1/5.
 */

public class MainLocalServiceImpl implements MainLocalService {

    private Db db;
    @Inject
    public MainLocalServiceImpl(Db db) {
        this.db = db;
    }

    @Override
    public void login(User user) {
        db.save(user);
    }

    @Override
    public void logout(User user) {
        User tempUser =new User();
        tempUser.setId(user.getId());
        tempUser.setName(user.getLoginName());
        db.updateById(tempUser,user.getId());
    }
}
