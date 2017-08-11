package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public interface BaseService {

    @POST("listCategories")
    Observable<String> getClassificationRequst(@QueryMap Map<String,String> map);


}
