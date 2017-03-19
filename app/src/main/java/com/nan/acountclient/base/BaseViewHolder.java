package com.nan.acountclient.base;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wzn on 2017/3/12.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public  <T extends View> T getView(int viewId, Class<T> clazz){
        return (T)getView(viewId);
    };



    public BaseViewHolder setText(int viewId, String text) {
        ((TextView) getView(viewId)).setText(text);
        return this;
    }


    public BaseViewHolder setDrawble(int viewId, Drawable drawable) {
        ((ImageView) getView(viewId)).setImageDrawable(drawable);
        return this;
    }
    public BaseViewHolder setImageResource(int viewId, int  resId) {
        ((ImageView) getView(viewId)).setImageResource(resId);
        return this;
    }

    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        getView(viewId).setOnClickListener(onClickListener);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener onLongClickListener) {
        getView(viewId).setOnLongClickListener(onLongClickListener);
        return this;
    }


}