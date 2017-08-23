package com.example.aensun.leedodoprogect.modle.net;

import com.example.aensun.leedodoprogect.modle.bean.LoginPhoneBean;
import com.example.aensun.leedodoprogect.modle.bean.PhoneCodeBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by aensun on 2017-08-03.
 */

public interface ApiService {

    /**
     * 短信验证登录
     *
     * @param phone
     * @param merchant
     * @param type
     * @return
     */
    @POST("sendCode")
    Observable<PhoneCodeBean> getPhoneBean(@Query("phone") String phone, @Query("merchant") int merchant, @Query("type") int type);

    /**
     * 注册
     * @param phone
     * @param password
     * @param code
     * @param merchant
     * @return
     */
    @POST("user/register")
    Observable<PhoneCodeBean> registerPhone(@Query("phone") String phone, @Query("password") String password, @Query("code") String code, @Query("merchant") int merchant);

    /**
     * @param phone
     * @param password
     * @param merchant
     * @return
     */
    @POST("user/login")
    Observable<LoginPhoneBean> loginPhone(@Query("phone") String phone, @Query("password")String password, @Query("merchant") int merchant);


    /**
     * 忘记密码
     * @param phone
     * @param code
     * @param token
     * @param password
     * @return
     */
    @POST("user/resetPassword")
    Observable<PhoneCodeBean> forgtoPassWord(@Query("phone") String phone,@Query("code") String code,@Query("token") String token,@Query("password") String password);
}
