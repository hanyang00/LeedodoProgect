package com.example.aensun.leedodoprogect.view.activity;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/14 17:08
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);
    }
}
