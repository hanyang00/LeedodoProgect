package com.example.aensun.leedodoprogect.view.fragment.homeFragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapters.HomeClassificationRecycleAdapter;
import com.example.aensun.leedodoprogect.view.fragment.BaseFragment;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.ClassificBean;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.BaseService;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.utils.UrlUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public class ClassificationFragment_1 extends BaseFragment {


    @Bind(R.id.home_Classification_Recycle)
    RecyclerView homeClassificationRecycle;

    @Override
    protected View setConnectViews() {
        View view = View.inflate(getActivity(), R.layout.classification_fragment, null);
        return view;
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("pageSize", "10");
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(UrlUtils.baseUrl)
                .build();
        BaseService baseService = retrofit.create(BaseService.class);
        baseService.getClassificationRequst(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.w("Tag------", "onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        String json = s.toString();
                        Log.w("Tag------", json);
                        Gson gson = new Gson();
                        ClassificBean classificBean = gson.fromJson(json, ClassificBean.class);
                        List<ClassificBean.ObjectBean.ListBean> classificList = classificBean.object.list;


                        HomeClassificationRecycleAdapter classifAdapter = new HomeClassificationRecycleAdapter(getActivity(),classificList);
                        homeClassificationRecycle.setLayoutManager(new GridLayoutManager(getActivity(),5));
                        homeClassificationRecycle.setAdapter(classifAdapter);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.w("Tag------", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.w("Tag------", "onComplete");
                    }
                });

    }

    @Override
    protected void initDataFromServer() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
