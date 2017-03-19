package com.nan.acountclient.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wzn on 2017/3/12.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected List<T> lstData;
    protected Context mContext;
    protected OnClickListener mOnClickListener;
    protected OnLongClickListener mOnLongClickListener;

    public BaseAdapter(List<T> lstData, Context context) {
        this.lstData = lstData;
        this.mContext = context;
    }


    protected  int getViewType(int position, T item){
        return 0;
    }


    protected abstract int getLayoutId(int viewType);

    protected View getLayoutView(ViewGroup parent,int viewType) {
        return null;
    }

    protected abstract void convert(BaseViewHolder holder, int position, T item);




    @Override
    public int getItemViewType(int position) {
        return getViewType(position, lstData.get(position));
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view=getLayoutView(parent,viewType);
        if (view==null){
            view = LayoutInflater.from(mContext).inflate(getLayoutId(viewType), parent, false);
        }
        return new BaseViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        if(mOnClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.onClick(holder, position);
                }
            });

        }
        if(mOnLongClickListener!=null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mOnLongClickListener.onLongClick(holder,position);
                }
            });

        }
        convert(holder,position,lstData.get(position));
    }


    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public interface OnClickListener {
        void onClick(BaseViewHolder holder, int position);
    }

    public interface OnLongClickListener {
        boolean onLongClick(BaseViewHolder holder, int position);
    }

    public OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }
    public OnLongClickListener getOnLongClickListener() {
        return mOnLongClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener mOnLongClickListener) {
        this.mOnLongClickListener = mOnLongClickListener;
    }


}
