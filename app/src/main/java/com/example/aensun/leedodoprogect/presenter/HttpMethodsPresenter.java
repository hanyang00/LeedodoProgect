package com.example.aensun.leedodoprogect.presenter;

import com.example.aensun.leedodoprogect.modle.bean.LoginPhoneBean;
import com.example.aensun.leedodoprogect.modle.bean.PhoneCodeBean;
import com.example.aensun.leedodoprogect.modle.net.ApiService;
import com.example.aensun.leedodoprogect.modle.net.ConstantPool;



import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/*
 * Created by aensun on 2017-08-03.
 */

public class HttpMethodsPresenter {


    private final ApiService apiService;


    private HttpMethodsPresenter() {

        Retrofit mRetrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ConstantPool.BASE_URL)
                .build();

        apiService = mRetrofit.create(ApiService.class);

    }

    private static  class   SingletonHolder{
        private static final  HttpMethodsPresenter INSTANCE =new HttpMethodsPresenter();
    }

    public static HttpMethodsPresenter getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 短信验证码
     * @param Observer
     * @param phone
     * @param merchant
     * @param type
     */
    public void getPhoneCode(Observer<PhoneCodeBean> Observer , String phone , int merchant, int type ){

        apiService.getPhoneBean(phone,merchant,type)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Observer);

    }

    /**
     * 注册
     * @param observer
     * @param phone
     * @param passWord
     * @param code
     * @param merchant
     */
    public void getRegisterPhone(Observer<PhoneCodeBean> observer, String phone,String passWord,String code,int merchant){
        apiService.registerPhone(phone,passWord,code,merchant)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }


    /**
     * 登录
     * @param observer
     * @param phone
     * @param passWord
     * @param merchant
     */
    public void loginPhone(Observer<LoginPhoneBean> observer,String phone,String passWord,int merchant){
        apiService.loginPhone(phone,passWord,merchant)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }

    /**
     * 忘记密码
     * 重置密码
     * @param observer
     * @param phone
     * @param code
     * @param token
     * @param passWord
     */

    public void forgotPassWord(Observer<PhoneCodeBean> observer,String phone,String code,String token,String passWord){
        apiService.forgtoPassWord(phone,code,token,passWord)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 更换手机号
     * @param observer
     * @param phone
     * @param code
     * @param token
     */

    public void  replacePhone(Observer<PhoneCodeBean> observer,String phone,String code,String token){
        apiService.replacePhone(phone,code,token)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }



}
