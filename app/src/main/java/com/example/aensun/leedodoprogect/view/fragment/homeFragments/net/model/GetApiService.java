package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.BaseService;

import java.util.Map;

import io.reactivex.Observable;

/**
 * date:2017/8/17
 * author:张毛第
 * function:
 */

public class GetApiService {
    public static GetApiService instance;
    BaseService baseService;

    private GetApiService() {
        baseService = GetRequest.getService();
    }

    public static GetApiService getInstance() {
        if (instance == null) {
            synchronized (GetApiService.class) {
                if (instance == null) {
                    instance = new GetApiService();
                }
            }
        }
        return instance;
    }


    Observable<String> getObservableClassif(Map<String, String> map, String url) {
        Observable<String> classificationRequst = baseService.getClassificationRequst(url, map);
        return classificationRequst;
    }

}
