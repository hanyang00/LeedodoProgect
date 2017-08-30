package com.example.aensun.leedodoprogect.modle.bean;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by aensun on 2017-08-29.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
