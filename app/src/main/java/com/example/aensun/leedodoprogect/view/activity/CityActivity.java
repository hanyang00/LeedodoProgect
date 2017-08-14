package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapters.CitiesAdapter;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.CityBean;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetCityResults;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ICitySponesView;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.views.CityQuickIndexView;
import com.google.gson.Gson;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CityActivity extends BaseActivity implements ICitySponesView {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.quickIndexView)
    CityQuickIndexView quickIndexView;
    private CitiesAdapter adapter;
    private List<CityBean.ObjectBean> list;

    @Override
    protected int setContentViews() {
        return R.layout.activity_city;
    }

    @Override
    protected void initData() {
        GetCityResults cityResults = new GetCityResults(this);
        cityResults.getData();
        initEvent();
    }

    @Override
    public void requestSuccess(String results) {
//        Log.w("CITY============", results.toString());
        String json = results.toString();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Gson gson = new Gson();
        CityBean cityBean = gson.fromJson(json, CityBean.class);
        list = cityBean.object;
        adapter = new CitiesAdapter(this, list);
        recyclerView.setAdapter(adapter);

    }

    private void initEvent() {
        quickIndexView.setOnIndexChangeListener(new CityQuickIndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String words) {
                if(words.equals("当") || words.equals("热")){
                    LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                            .getLayoutManager();
                    llm.scrollToPositionWithOffset(0, 0);
                    return;
                }
                List<CityBean.ObjectBean> datas = adapter.getData();
                if(datas!=null && datas.size()>0) {
                    int count = 0;
                    for (int i = 0; i < datas.size(); i++) {
                        CityBean.ObjectBean datasBean = datas.get(i);

                        if(datasBean.areaname.equals(words)){
                            LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                                    .getLayoutManager();
                            llm.scrollToPositionWithOffset(count+1, 0);
                            return;
                        }
                        count+=datas.size();
                    }
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
