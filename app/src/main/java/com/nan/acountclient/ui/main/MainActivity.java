package com.nan.acountclient.ui.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.nan.acountclient.R;
import com.nan.acountclient.base.BaseActivity;

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
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        setupDrawerContent(navView);
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
                switch (item.getItemId()){

                }
                item.setCheckable(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
