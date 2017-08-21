package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 类描述：
 * 创建人：yangyongli
 * 创建时间：2017/8/19 14:58
 */
public interface PostNet {
    @POST
    Observable<String> LodeDate(@Url String url, @QueryMap Map<String ,String> map);

}
