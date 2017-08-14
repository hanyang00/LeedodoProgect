package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model;

import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.BaseService;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.utils.UrlUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * date:2017/8/14
 * author:张毛第
 * function:
 */

public class GetNearShopRequest implements IGetNearShopRequest {
    @Override
    public void getNearShops(Map<String, String> map) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(UrlUtils.baseUrl)
                .build();
        BaseService service = retrofit.create(BaseService.class);
        service.getClassificationRequst(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        if (s != null) {
                            callBack.requestSuccess(s.toString());
                        }


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface CallBack {
        void requestSuccess(String resutls);
    }

    CallBack callBack;

    public GetNearShopRequest(CallBack callBack) {
        this.callBack = callBack;
    }
}
