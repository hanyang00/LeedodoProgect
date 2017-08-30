package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.BaseService;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.utils.UrlUtils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * date:2017/8/17
 * author:张毛第
 * function:
 */

public class GetRequest {
    static Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(UrlUtils.baseUrl)
            .build();

    public static BaseService getService() {
        return retrofit.create(BaseService.class);
    }
}
