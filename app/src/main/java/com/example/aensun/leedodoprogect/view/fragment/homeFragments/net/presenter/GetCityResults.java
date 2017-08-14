package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model.GetClassificationRequest;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ICitySponesView;

/**
 * date:2017/8/12
 * author:张毛第
 * function:
 */

public class GetCityResults implements GetClassificationRequest.CallBack {

    GetClassificationRequest classificationRequest;
    ICitySponesView iCitySponesView;

    public GetCityResults(ICitySponesView iCitySponesView) {
        this.iCitySponesView = iCitySponesView;
        classificationRequest = new GetClassificationRequest(this);
    }
    public void getData(){
        classificationRequest.getCityData();
    }
    @Override
    public void requestSuccess(String resutls) {
            iCitySponesView.requestSuccess(resutls.toString());
    }

}
