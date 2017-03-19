package com.nan.acountclient.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

import static com.nan.acountclient.R.id.rootView;

/**
 * Created by wzn on 2017/3/5.
 */

public abstract class SimpleFragment extends Fragment {
    protected Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(getLayoutId(),container,false);
        init(view);
        initData();
        initView();
        loadData();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void loadData();

    private void init( View view) {
        mContext=getContext();
        ButterKnife.inject(this,view );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }



}
