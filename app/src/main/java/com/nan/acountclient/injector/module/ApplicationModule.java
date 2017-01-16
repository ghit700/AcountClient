package com.nan.acountclient.injector.module;

import android.content.Context;
import android.preference.PreferenceManager;

import com.nan.acountclient.components.db.Db;
import com.nan.acountclient.components.db.TableHelper;
import com.nan.acountclient.components.okhttp.HeaderInterceptor;
import com.nan.acountclient.components.okhttp.HttpLoggingInterceptor;
import com.nan.acountclient.config.Config;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.local.impl.MainLocalServiceImpl;
import com.nan.acountclient.data.remote.MainRemoteService;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by wzn on 2016/11/28.
 */
@Module
public class ApplicationModule {
    public final Context mContext;
    public final Db mDb;
    public final OkHttpClient client;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
        mDb = Db.getInstance();
        mDb.init(new TableHelper(mContext));
        client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new HttpLoggingInterceptor())
                .connectTimeout(Config.networkTimeout, TimeUnit.SECONDS)
                .readTimeout(Config.networkTimeout, TimeUnit.SECONDS)
                .writeTimeout(Config.networkTimeout, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public Db provideDb() {
        return mDb;
    }

    @Singleton
    @Provides
    public User provideUser() {
        long uid = PreferenceManager.getDefaultSharedPreferences(mContext).getLong("loginUid", -1);
        User user = null;
        if (uid != -1) {
            user = Db.getInstance().queryById(User.class, uid);
        }
        return user;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return client;
    }

    @Singleton
    @Provides
    public MainRemoteServiceAPI provideMainRemoteService() {
        return new MainRemoteServiceAPI(client);
    }

    @Singleton
    @Provides
    public MainLocalService provideMainLocalService() {
        return new MainLocalServiceImpl(mDb,mContext);
    }


}
