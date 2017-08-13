package com.example.aensun.leedodoprogect.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public class ViewPagerAndFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mlist;
    public ViewPagerAndFragmentAdapter(FragmentManager fm,ArrayList<Fragment> mlist) {
        super(fm);
        this.mlist=mlist;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }
}
