package com.nan.acountclient.injector.module;

import android.content.Context;
import android.preference.PreferenceManager;

import com.nan.acountclient.components.db.Db;
import com.nan.acountclient.components.db.TableHelper;
import com.nan.acountclient.entity.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wzn on 2016/11/28.
 */
@Module
public class ApplicationModule {
    private final Context mContext;
    private final Db mDb;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
        mDb.init(new TableHelper(mContext));
        mDb=Db.getInstance();
    }

    @Singleton
    @Provides
    public Db provideDb() {
        return mDb;
    }
    @Singleton
    @Provides
    public User provideUser(){
        long uid= PreferenceManager.getDefaultSharedPreferences(mContext).getLong("loginUid",-1);
        User user=null;
        if (uid!=-1){
            user=Db.getInstance().queryById(User.class,uid);
        }
        return user;
    }
}
