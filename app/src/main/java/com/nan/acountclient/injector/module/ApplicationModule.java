package com.nan.acountclient.injector.module;

import android.content.Context;
import android.preference.PreferenceManager;

import com.nan.acountclient.components.okhttp.HeaderInterceptor;
import com.nan.acountclient.components.okhttp.HttpLoggingInterceptor;
import com.nan.acountclient.config.Config;
import com.nan.acountclient.data.local.MainLocalService;
import com.nan.acountclient.data.local.impl.MainLocalServiceImpl;
import com.nan.acountclient.data.remote.impl.MainRemoteServiceAPI;
import com.nan.acountclient.entity.User;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;

/**
 * Created by wzn on 2016/11/28.
 */
@Module
public class ApplicationModule {
    public final Context mContext;
    public final OkHttpClient mClient;
    public final Realm mRealm;

    public ApplicationModule(Context mContext) {
        this.mContext = mContext;
        mClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new HttpLoggingInterceptor())
                .connectTimeout(Config.networkTimeout, TimeUnit.SECONDS)
                .readTimeout(Config.networkTimeout, TimeUnit.SECONDS)
                .writeTimeout(Config.networkTimeout, TimeUnit.SECONDS)
                .build();
        Realm.init(mContext);
        RealmConfiguration configuration=new RealmConfiguration.Builder()
                .name(Config.db_name)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
        mRealm=Realm.getDefaultInstance();

    }

    @Singleton
    @Provides
    public Realm provideRealm(){
        return mRealm;
    }

    @Singleton
    @Provides
    public User provideUser() {
        long uid = PreferenceManager.getDefaultSharedPreferences(mContext).getLong("loginUid", -1);
        User user = null;

        return user;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return mClient;
    }

    @Singleton
    @Provides
    public MainRemoteServiceAPI provideMainRemoteService() {
        return new MainRemoteServiceAPI(mClient);
    }

    @Singleton
    @Provides
    public MainLocalService provideMainLocalService() {
        return new MainLocalServiceImpl(mContext);
    }


}
