package com.nan.acountclient.components.rx;

import android.support.annotation.NonNull;

import com.nan.acountclient.base.BasePresenter;
import com.nan.acountclient.base.BaseView;

import java.lang.ref.WeakReference;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by wzn on 2017/2/9.
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;
    private WeakReference<T> reference;
    protected CompositeSubscription mCompositeSubscription;

    protected void unSubscribe(){
        if (mCompositeSubscription!=null){
            mCompositeSubscription.unsubscribe();
        }
    }
    protected void addSubscribe(Subscription subscription){
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void attachView(@NonNull T view) {
        reference=new WeakReference<>(view);
        this.mView=reference.get();
    }

    @Override
    public void detachView() {
        this.mView=null;
        unSubscribe();
    }
}
