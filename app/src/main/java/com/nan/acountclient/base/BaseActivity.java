package com.nan.acountclient.base;

import javax.inject.Inject;




/**
 * Created by wzn on 2016/12/12.
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {


    @Inject
    protected T mPresenter;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }

    public void init() {
        super.init();
        mPresenter.attachView(this);
    }





}
