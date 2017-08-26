package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 类描述：请求网络
 * 创建人：yangyonli
 * 创建时间：2017/8/19 14:56
 */
public class NetUtils {


    private NetCall netCall;
    private static NetUtils netu;

    private NetUtils() {
    }

    public static synchronized NetUtils getNertUtiles() {
        if (netu == null) {
            netu = new NetUtils();
        }
        return netu;
    }

    //retrofit+Rxjava  请求网络
    public void getLaddeDate(String url, Map<String, String> map, final NetCall netCall) {
        this.netCall = netCall;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://123.57.33.185:8088/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        PostNet postNet = retrofit.create(PostNet.class);
        Observable<String> observable = postNet.LodeDate(url, map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        netCall.Succeed(s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        netCall.Err(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}
