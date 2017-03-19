package com.nan.acountclient.ui.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.nan.acountclient.R;
import com.nan.acountclient.base.BaseActivity;
import com.nan.acountclient.ui.add.AddAccountActivity;
import com.nan.acountclient.ui.add.TagFragment;
import com.nan.acountclient.entity.data.ErrorData;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wzn on 2016/12/12.
 */

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @InjectView(R.id.tb)
    Toolbar tb;
    @InjectView(R.id.btnMainAdd)
    FloatingActionButton btnMainAdd;
    @InjectView(R.id.nav_view)
    NavigationView navView;
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.tvMainBillOut)
    TextView tvMainBillOut;
    @InjectView(R.id.tvMainBillIn)
    TextView tvMainBillIn;
    @InjectView(R.id.tlMainBill)
    TabLayout tlMainBill;
    @InjectView(R.id.vpMainBill)
    ViewPager vpMainBill;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setToolBar(tb, "首页");
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        //drawer
        setupDrawerContent(navView);
        //tab
        vpMainBill.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new TagFragment(position);
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position+" ";
            }
        });
        tlMainBill.setupWithViewPager(vpMainBill);


    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initComponent() {
        getActivityComponent().inject(this);
    }


    @OnClick(R.id.btnMainAdd)
    public void onClick() {
        to(AddAccountActivity.class, new Intent());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navView) {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                }
                item.setCheckable(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
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
