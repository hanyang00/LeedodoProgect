package com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.model;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2017/8/17
 * author:张毛第
 * function:
 */

public class GetNetApi {

    public void getRespones(String url,Map<String,String> map){

        GetApiService.getInstance().getObservableClassif(map,url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        callBack.requestSuccess(s.toString());
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
        void requestSuccess(String s);
    }

    CallBack callBack;

    public GetNetApi(CallBack callBack) {
        this.callBack = callBack;
    }
}
