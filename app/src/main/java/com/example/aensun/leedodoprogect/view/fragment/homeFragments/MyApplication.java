package com.example.aensun.leedodoprogect.view.fragment.homeFragments;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * date:2017/8/28
 * author:张毛第
 * function:
 */

public class MyApplication extends Application{
    private RefWatcher mRefWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        mRefWatcher = LeakCanary.install(this);
    }
}
