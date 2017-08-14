package com.example.aensun.leedodoprogect.presenter;

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

    public void getPhoneCode(Observer<PhoneCodeBean> Observer , String phone , int merchant, int type ){

        apiService.getPhoneBean(phone,merchant,type)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Observer);

    }

    public void getRegisterPhone(Observer<PhoneCodeBean> observer, String phone,String passWord,String code,int merchant){

        apiService.registerPhone(phone,passWord,code,merchant)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }



}
