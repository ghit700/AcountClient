package com.nan.acountclient.ui.add;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.nan.acountclient.R;
import com.nan.acountclient.base.BaseAdapter;
import com.nan.acountclient.base.BaseViewHolder;
import com.nan.acountclient.base.SimpleFragment;
import com.nan.acountclient.utils.AccountUtils;
import com.nan.acountclient.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;


/**
 * Created by wzn on 2017/3/5.
 */

public class TagFragment extends SimpleFragment {

    @InjectView(R.id.listTab)
    RecyclerView listTab;
    private List<String> lstTabs;
    /**
     * 当前tab的页数
     */
    private int mPage;



    public TagFragment(int page) {
        mPage=page;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab;
    }

    @Override
    protected void initData() {
        lstTabs=new ArrayList<>();
        for(int i=0;i<AccountUtils.getPageTabCount(mPage);i++){
            lstTabs.add(getString(AccountUtils.getTabName(mPage,i)));
        }
    }

    @Override
    protected void initView() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 5);
        listTab.setLayoutManager(gridLayoutManager);
        TabAdapter adapter=new TabAdapter(lstTabs,mContext,listTab,mPage);
        adapter.setOnClickListener(new BaseAdapter.OnClickListener() {
            @Override
            public void onClick(BaseViewHolder holder, int position) {
                ImageView img=holder.getView(R.id.imgTag);
                Drawable drawable = img.getDrawable();
                ImageView imageView= ((ImageView)getActivity().findViewById(R.id.imgAddTag));
                imageView.setImageDrawable(drawable);
                imageView.setTag(mPage*10+position);
                AppUtils.closeInputMethodManager(getActivity());
            }
        });
        listTab.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

    }


}
