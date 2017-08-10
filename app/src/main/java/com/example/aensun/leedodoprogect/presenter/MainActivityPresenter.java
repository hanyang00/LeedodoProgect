package com.example.aensun.leedodoprogect.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.activity.MainActivity;

/**
 * Created by aensun on 2017-08-10.
 */

public class MainActivityPresenter {

    private   MainActivity mainActivity;

    public MainActivityPresenter(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    private   Fragment fragments;

    /**
     * 添加fragment 显示和隐藏
     * @param fragment
     */
    public  void dataFragment(Fragment fragment) {

        FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (fragment.isAdded()) {
            if (fragments != fragment) {
                fragmentTransaction.hide(fragments);
                fragmentTransaction.show(fragment);
                fragments = fragment;
            }
        } else {
            fragmentTransaction.add(R.id.add_frament_Layout, fragment);
            if (fragments != null) {
                if (fragments != fragment) {
                    fragmentTransaction.hide(fragments);
                }
            }

            fragments = fragment;
        }

        fragmentTransaction.commit();
    }
}
