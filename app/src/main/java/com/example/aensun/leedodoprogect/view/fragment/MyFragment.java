package com.example.aensun.leedodoprogect.view.fragment;

import android.view.View;

import com.example.aensun.leedodoprogect.R;

/**
 * Created by aensun on 2017-08-10.
 */

public class MyFragment extends BaseFragment{
    @Override
    protected View setConnectViews() {
        View view=View.inflate(getActivity(), R.layout.my_fragment,null);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initDataFromServer() {

    }
}
