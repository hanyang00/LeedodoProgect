package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model.GetNetApi;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ISuccessView;

import java.util.Map;

/**
 * date:2017/8/17
 * author:张毛第
 * function:
 */

public class GetRespones implements GetNetApi.CallBack {


    ISuccessView iSuccessView;
    GetNetApi getNetApi;

    public GetRespones(ISuccessView iSuccessView) {
        this.iSuccessView = iSuccessView;
        this.getNetApi = new GetNetApi(this);
    }

    public void getData(String url,Map<String,String> map){
        getNetApi.getRespones(url,map);
    }


    @Override
    public void requestSuccess(String s) {
        iSuccessView.requestSuccessI(s);
    }
    public void deasd(){
        iSuccessView = null;
    }
}
