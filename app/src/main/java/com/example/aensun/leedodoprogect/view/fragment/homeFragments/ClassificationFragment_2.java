package com.example.aensun.leedodoprogect.view.fragment.homeFragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapters.HomeClassificationRecycleAdapter;
import com.example.aensun.leedodoprogect.view.fragment.BaseFragment;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.ClassificBean;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetRespones;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ISuccessView;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.utils.GridSpacingItemDecoration;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.attr.duration;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public class ClassificationFragment_2<T> extends BaseFragment implements ISuccessView{


    @Bind(R.id.home_Classification_Recycle_2)
    RecyclerView homeClassificationRecycle2;
    private GetRespones getRespones;

    @Override
    protected View setConnectViews() {
        View view = View.inflate(getActivity(), R.layout.classification_fragment_2, null);
        return view;
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("pageSize", "10");
        map.put("pageNum", "2");

        getRespones = new GetRespones(this);
        getRespones.getData("listCategories",map);
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
        getRespones.deasd();
    }


    @Override
    public void requestSuccessI(String results) {
        if (results!=null){

            Gson gson = new Gson();
            ClassificBean classificBean = gson.fromJson(results, ClassificBean.class);
            List<ClassificBean.ObjectBean.ListBean> classificList = classificBean.object.list;
            homeClassificationRecycle2.setLayoutManager(new GridLayoutManager(getActivity(), 5, GridLayoutManager.VERTICAL, false));
            homeClassificationRecycle2.addItemDecoration(new GridSpacingItemDecoration(5, getResources().getDimensionPixelSize(R.dimen.padding_middle), true));
            homeClassificationRecycle2.setHasFixedSize(true);
            HomeClassificationRecycleAdapter classifAdapter = new HomeClassificationRecycleAdapter(getActivity(), classificList);
            homeClassificationRecycle2.setAdapter(classifAdapter);

            classifAdapter.HomeClassificationRecycleAdapter(new HomeClassificationRecycleAdapter.RecyclesetOnItemClick() {
                @Override
                public void itemClick(int position) {
                    Snackbar.make(getView(), "" + position, duration).show();
                }
            });
        }

    }
}

