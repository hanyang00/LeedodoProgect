package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model.GetNearShopRequest;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.INearShopsView;

import java.util.Map;

/**
 * date:2017/8/14
 * author:张毛第
 * function:
 */

public class GetNearShopsResults implements GetNearShopRequest.CallBack{


    GetNearShopRequest getNearShopRequest;
    INearShopsView iNearShopsView;

    public GetNearShopsResults(INearShopsView iNearShopsView) {
        this.getNearShopRequest = new GetNearShopRequest(this);
        this.iNearShopsView = iNearShopsView;
    }

    public void getData(Map<String,String> map){
        getNearShopRequest.getNearShops(map);
    }

    @Override
    public void requestSuccess(String resutls) {
            iNearShopsView.requestSuccess(resutls);
    }
}
