package com.example.aensun.leedodoprogect.view.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByFragments.NerByAllFragment;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerTabLayoutFragment;

/**
 * 类描述：TabLayout的适配器
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

    /**
     * 根据不同的Title返回不同的Franmengt
     */
    @Override
    public Fragment getItem(int position) {
        //Fragment返回不同Fragment的静态方法
        if(strs[position].equals("全部")){
            return new NerByAllFragment();
        }else{
            return NerTabLayoutFragment.getFragment("findShopById",strs[position]);
        }

    }

    @Override
    public int getCount() {
        return strs.length;
    }
}
