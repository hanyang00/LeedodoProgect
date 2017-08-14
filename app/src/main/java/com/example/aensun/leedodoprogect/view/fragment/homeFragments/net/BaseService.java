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

    //首页分类
    @POST("listCategories")
    Observable<String> getClassificationRequst(@QueryMap Map<String, String> map);

    //城市列表
    @POST("/findAllCityList")
    Observable<String> getCityRequst();

    //附近旺铺
    @POST("/near/shops")
    Observable<String> getNearShops(@QueryMap Map<String, String> map);

    //轮播图
    @POST("/listRecommendPositions")
    Observable<String> getRoundPic(@QueryMap Map<String, String> map);

}
