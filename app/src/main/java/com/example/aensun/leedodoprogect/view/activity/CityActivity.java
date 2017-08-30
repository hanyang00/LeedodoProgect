package com.example.aensun.leedodoprogect.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapters.SortAdapter;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.CityBean;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetRespones;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ISuccessView;
import com.example.aensun.leedodoprogect.view.fragment.view.CitySortModel;
import com.example.aensun.leedodoprogect.view.fragment.view.EditTextWithDel;
import com.example.aensun.leedodoprogect.view.fragment.view.PinyinComparator;
import com.example.aensun.leedodoprogect.view.fragment.view.PinyinUtils;
import com.example.aensun.leedodoprogect.view.fragment.view.SideBar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityActivity extends BaseActivity implements ISuccessView {

    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog, mTvTitle;
    private SortAdapter adapter;
    private EditTextWithDel mEtCityName;

    private List<CityBean.ObjectBean> cityList  ;
    List<CitySortModel> slist = new ArrayList<>();
    private List<String> cityName;
    private List<CitySortModel> mSortList  = new ArrayList<>();
    private GetRespones getRespones;


    @Override
    protected int setContentViews() {
        return R.layout.activity_city;
    }

    @Override
    protected void initData() {

        Map<String, String> map = new HashMap<>();
        map.put("", "");
        getRespones = new GetRespones(this);
        getRespones.getData("/findAllCityList", map);
        initViews();



    }
    private void initViews() {
        mEtCityName = (EditTextWithDel) findViewById(R.id.et_search);
        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        initDatas();
        initEvents();
        setAdapter();
    }

    @Override
    public void requestSuccessI(String results) {
        Gson gson = new Gson();
        CityBean cityBean = gson.fromJson(results, CityBean.class);
        cityList = cityBean.object;
        cityName = new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++) {
            CityBean.ObjectBean objectBean = cityList.get(i);
            cityName.add(objectBean.areaname);
        }
        slist =   filledData(cityName);
        adapter.updateListView(slist);
        Collections.sort(slist, new PinyinComparator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }


    private void setAdapter() {
        adapter = new SortAdapter(this, slist);
//        sortListView.addHeaderView(initHeadView());
        sortListView.setAdapter(adapter);
    }

    private void initEvents() {
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position );
                }
            }
        });

        //根据输入框输入值的改变来过滤搜索
        mEtCityName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //ListView的点击事件
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                mTvTitle.setText("当前城市："+mSortList.get(position).getName());
                mTvTitle.setText("当前城市：" +((CitySortModel)adapter.getItem(position)).getName());
//                mTvTitle.setText(((CitySortModel) adapter.getItem(position - 1)).getName());
                Toast.makeText(getApplication(), ((CitySortModel)adapter.getItem(position)).getName(),Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }

    private void initDatas() {
        sideBar.setTextView(dialog);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getRespones.deasd();

    }


    //根据输入框中的值来过滤数据并更新ListView
    private void filterData(String filterStr) {
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = slist;
        } else {
            mSortList.clear();
            for (CitySortModel sortModel : slist) {
                String name = sortModel.getName();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparator());
        adapter.updateListView(mSortList);
    }

    private List<CitySortModel> filledData(List<String> date) {
       List<CitySortModel> mSort = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            CitySortModel sortModel = new CitySortModel();
            sortModel.setName(date.get(i));
            String pinyin = PinyinUtils.getPingYin(date.get(i));
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
            mSort.add(sortModel);
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        return mSort;
    }
}
