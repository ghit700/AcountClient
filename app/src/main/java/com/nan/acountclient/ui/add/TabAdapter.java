package com.nan.acountclient.ui.add;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nan.acountclient.R;
import com.nan.acountclient.base.BaseAdapter;
import com.nan.acountclient.base.BaseViewHolder;
import com.nan.acountclient.utils.AccountUtils;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import java.util.List;



/**
 * Created by wzn on 2017/3/12.
 */

public class TabAdapter extends BaseAdapter<String>  {
    private RecyclerView mRecyclerView;
    private int mPage;

    public TabAdapter(List lstData, Context context, RecyclerView recyclerView, int page) {
        super(lstData, context);
        mRecyclerView = recyclerView;
        mPage = page;
    }

    @Override
    protected View getLayoutView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab, parent, false);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mRecyclerView.getHeight() / 2));
        return view;
    }

    @Override
    protected int getLayoutId(int viewType) {
        return 0;
    }

    @Override
    protected void convert(BaseViewHolder holder, int position, String item) {
        holder.setDrawble(R.id.imgTag, MaterialDrawableBuilder.with(mContext)
                .setIcon(AccountUtils.getTabDrawable(mPage, position))
                .build());
        holder.setText(R.id.tvTag,item);
    }
}
