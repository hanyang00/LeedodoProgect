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

public class HomeClassificationViewPagerAdapter extends FragmentPagerAdapter {

    Context context;
    List<Fragment> fList;


    public HomeClassificationViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> fList) {
        super(fm);
        this.context = context;
        this.fList = fList;
    }

    @Override
    public Fragment getItem(int position) {
        return fList.get(position);
    }

    @Override
    public int getCount() {
        return fList!=null?fList.size():0;
    }

}
