package com.shehuan.library.test;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.shehuan.statusview.StatusView;
import com.shehuan.statusview.StatusViewBuilder;
import com.shehuan.library.test.base.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private StatusView statusView;

    @OnClick(R.id.tv_start)
    public void start() {
        startActivity(new Intent(this, TabActivity.class));
    }

    @Override
    protected int initLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        statusView = StatusView.init(this, R.id.tv_start);
        statusView.showLoadingView();//显示logding加载
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                statusView.showContentView();//显示原始内容
                statusView.showEmptyView();//显示暂无数据
//                statusView.showErrorView();//显示账户下线
            }
        }, 1000);


        statusView.config(new StatusViewBuilder.Builder()
                //加载失败点击事件
                .setOnErrorRetryClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        statusView.showLoadingView();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                statusView.showEmptyView();//显示暂无数据
                            }
                        }, 1000);
                    }
                })
                //暂无数据点击事件
                .setOnEmptyRetryClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        statusView.showLoadingView();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                statusView.showErrorView();//显示加载失败
                            }
                        }, 1000);
                    }
                }).build());

    }
}
