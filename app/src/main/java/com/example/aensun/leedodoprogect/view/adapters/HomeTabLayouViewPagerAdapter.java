package com.example.aensun.leedodoprogect.view.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public class HomeTabLayouViewPagerAdapter extends FragmentPagerAdapter {
    Context context;
    List<Fragment> fList;
    List<String> tList;

    public HomeTabLayouViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> fList, List<String> tList) {
        super(fm);
        this.context = context;
        this.fList = fList;
        this.tList = tList;
    }

    @Override
    public Fragment getItem(int position) {
        return fList.get(position);
    }

    @Override
    public int getCount() {
        return fList != null ? fList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tList.get(position);
    }
}
