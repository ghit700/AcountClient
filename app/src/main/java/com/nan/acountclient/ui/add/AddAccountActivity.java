package com.nan.acountclient.ui.add;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nan.acountclient.R;
import com.nan.acountclient.base.BaseActivity;
import com.nan.acountclient.components.rx.RxBus;
import com.nan.acountclient.entity.Bill;
import com.nan.acountclient.entity.data.ErrorData;
import com.nan.acountclient.event.AddBillEvent;
import com.nan.acountclient.utils.AccountUtils;
import com.nan.acountclient.utils.AppUtils;
import com.nan.acountclient.utils.ToastUtils;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wzn on 2017/3/5.
 */

public class AddAccountActivity extends BaseActivity<AddAccountPresenter> implements AddAccountContract.View {
    @InjectView(R.id.tb)
    Toolbar tb;
    @InjectView(R.id.tvAddNumber)
    TextView tvAddNumber;
    @InjectView(R.id.vpAddTag)
    ViewPager vpAddTag;
    @InjectView(R.id.listAddNumberButton)
    RecyclerView listAddNumberButton;
    @InjectView(R.id.etAddRemark)
    EditText etAddRemark;
    @InjectView(R.id.imgAddTag)
    ImageView imgAddTag;

    @Override
    protected int getLayout() {
        return R.layout.activity_add_account;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setToolBar(tb, "记账");

        //tabfragment
        vpAddTag.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new TagFragment(position);
            }

            @Override
            public int getCount() {
                return AccountUtils.getTabPages();
            }
        });
        //数字键盘
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        listAddNumberButton.setLayoutManager(gridLayoutManager);
        NumberAdapter adapter = new NumberAdapter(mContext, listAddNumberButton);
        adapter.setOnClickListener(new NumberAdapter.OnClickListener() {
            @Override
            public void onClick(View v, int position) {
                if (position == 9) {
                    tvAddNumber.setText("0");
                } else {
                    if (tvAddNumber.getText().toString().trim().equals("0")) {
                        if (position != 10 && position != 11) {
                            tvAddNumber.setText(((TextView) v).getText().toString().trim());
                        } else if (position == 11) {
                            tvAddNumber.setText("0.");
                        }
                    } else {
                        if (position == 11 && tvAddNumber.getText().toString().trim().contains(".")) {
                            return;
                        }
                        tvAddNumber.setText(tvAddNumber.getText().toString().trim() + ((TextView) v).getText().toString().trim());
                    }
                }
            }
        });
        listAddNumberButton.setAdapter(adapter);


    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initComponent() {
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.tvAddNumber)
    public void onClick(View view) {
        AppUtils.closeInputMethodManager((Activity) mContext);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_check, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_add_check:
                if ("0".equals(tvAddNumber.getText().toString().trim())) {
                    ToastUtils.showToast(R.string.no_money);
                } else if (imgAddTag.getTag() == null) {
                    ToastUtils.showToast(R.string.no_tag);
                } else {
                    mPresenter.saveBill(Double.parseDouble(tvAddNumber.getText().toString().trim()),
                            (Integer) imgAddTag.getTag(),etAddRemark.getText().toString().trim());
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void saveSuccess(Bill bill) {
        RxBus.getDefault().post(new AddBillEvent(bill));
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(ErrorData errorData) {

    }
}
