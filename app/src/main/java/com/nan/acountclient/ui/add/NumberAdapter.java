package com.nan.acountclient.ui.add;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nan.acountclient.R;


/**
 * 添加账单的数字键盘adapter
 * Created by wzn on 2017/3/11.
 */

public class NumberAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private OnClickListener mOnClickListener;

    public NumberAdapter(Context context,RecyclerView recyclerView) {
        mContext=context;
        mRecyclerView=recyclerView;
    }
    public interface OnClickListener{
        void onClick(View v,int position);
    }
    public OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public void setOnClickListener(OnClickListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 9) {
            return 1;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == 1) {
            view = new LinearLayout(mContext);
            view.setBackgroundColor(Color.WHITE);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mRecyclerView.getHeight() / 4));
            ImageView img = new ImageView(mContext);
            img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_delete_black_24dp));
            ((LinearLayout) view).addView(img);
            ((LinearLayout) view).setGravity(Gravity.CENTER);
            view.setBackgroundResource(R.drawable.selector_number_button);
        } else {
            TextView tv = new TextView(mContext);
            tv.setGravity(Gravity.CENTER);
            tv.setBackgroundResource(R.drawable.selector_number_button);
            tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mRecyclerView.getHeight() / 4));
            view = tv;
        }
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder.itemView instanceof TextView) {
            if (position != 11 && position != 10) {
                ((TextView) holder.itemView).setText((position + 1) + "");
            } else if (position == 10) {
                ((TextView) holder.itemView).setText("0");
            } else {
                ((TextView) holder.itemView).setText(".");
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.onClick( v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 12;
    }
}
