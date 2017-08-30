package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model.GetNetApi;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ISuccessNearShops;

import java.util.Map;

/**
 * date:2017/8/17
 * author:张毛第
 * function:
 */

public class GetResponesNearShops implements GetNetApi.CallBack {
    ISuccessNearShops iSuccessNearShops;
    GetNetApi getNetApi;
    public GetResponesNearShops(ISuccessNearShops iSuccessNearShops) {
        this.iSuccessNearShops = iSuccessNearShops;
        this.getNetApi = new GetNetApi(this);
    }
    public void getNearData(String url, Map<String,String> map){
        getNetApi.getRespones(url,map);
    }
    public void deasd(){
        iSuccessNearShops = null;
    }

    @Override
    public void requestSuccess(String s) {
        iSuccessNearShops.requestSuccessNear(s);
    }
}
