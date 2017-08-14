package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model.GetClassificationRequest;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.IResponesView;

import java.util.Map;

/**
 * date:2017/8/12
 * author:张毛第
 * function:
 */

public class GetClassificationResults implements GetClassificationRequest.CallBack {


    GetClassificationRequest getClassificationRequest;
    IResponesView iResponesView;

    public GetClassificationResults(IResponesView iResponesView) {
        this.getClassificationRequest = new GetClassificationRequest(this);
        this.iResponesView = iResponesView;
    }

    public void getData(Map<String,String> map){
        getClassificationRequest.getData(map);
    }


    @Override
    public void requestSuccess(String results) {
        iResponesView.requestSuccess(results);
    }


}
