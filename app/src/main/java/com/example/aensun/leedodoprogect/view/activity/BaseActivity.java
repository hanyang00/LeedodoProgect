package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by aensun on 2017-08-10.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViews());
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract int setContentViews();

    public void initView() {

    }

    protected abstract void initData();



}
