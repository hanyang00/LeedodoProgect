package com.example.aensun.leedodoprogect.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerTabLayoutFragment;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/12 17:31
 */
public class NerByTabLayoutFragmentPageAdapter extends FragmentPagerAdapter {

    String[] strs={"美食","休闲娱乐","生活服务","酒店","全部"};

    public NerByTabLayoutFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return strs[position];
    }

    @Override
    public Fragment getItem(int position) {

        return NerTabLayoutFragment.getFragment(strs[position]);
    }

    @Override
    public int getCount() {
        return strs.length;
    }
}
