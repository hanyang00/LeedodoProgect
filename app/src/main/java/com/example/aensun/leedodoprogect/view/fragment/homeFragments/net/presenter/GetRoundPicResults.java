package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model.GetRoundPicRequest;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.IRoundPicView;

import java.util.Map;

/**
 * date:2017/8/14
 * author:张毛第
 * function:
 */

public class GetRoundPicResults implements GetRoundPicRequest.CallBack{

    IRoundPicView iRoundPicView;
    GetRoundPicRequest roundPicRequest;

    public GetRoundPicResults(IRoundPicView iRoundPicView) {
        this.iRoundPicView = iRoundPicView;
        this.roundPicRequest = new GetRoundPicRequest(this);
    }
    public void getRoundPic(Map<String,String> map){
        roundPicRequest.getRoundPic(map);
    }

    @Override
    public void requestSuccess(String resutls) {
        iRoundPicView.roundResults(resutls);
    }
}
