package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.NerByTabListBean;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByFragments.NerByTabListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AerbyItemBaiDuMessageActivity extends BaseActivity {
    @Bind(R.id.map)
    MapView mMapView;
    AMap aMap;
    @Bind(R.id.oneselflist)
    ListView onelist;
    private List<NerByTabListBean> list = new ArrayList<>();
    NerByTabListAdapter adqapter;

    @Bind(R.id.radiogroup)
    RadioGroup ridaogroup;

    @Bind(R.id.alllistview)
    ListView alllist;

    @Bind(R.id.all_fragment_lin)
    LinearLayout allfragmentlin;

    @Override
    protected int setContentViews() {
        return R.layout.activity_aerby_item_bai_du_message;
    }

    @Override
    protected void initData() {
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        //定位
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
//        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_MAP_ROTATE_NO_CENTER);//连续定位、蓝点不会移动到地图中心点，地图依照设备方向旋转，并且蓝点会跟随设备移动。
        LatLng latLng = new LatLng(39.906901, 116.397972);
     /*   MarkerOptions markerOption = new MarkerOptions();
        markerOption.title("西安市").snippet("西安市：34.341568, 108.940174");

        markerOption.draggable(true);//设置Marker可拖动
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(),R.mipmap.location)));
        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
        markerOption.setFlat(true);//设置marker平贴地图效果*/
        alllist.setVisibility(View.GONE);
        Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("北京").snippet("点击为北京"));
        LatLng latLng2 = new LatLng(34.341568, 108.940174);
        aMap.addMarker(new MarkerOptions().position(latLng2).title("西安").snippet("点击为西安"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        mMapView.onCreate(savedInstanceState);
        /**
         * 接收传过来的值
         */
        allfragmentlin.setVisibility(View.GONE);
        Intent it = this.getIntent();
        NerByTabListBean baen = (NerByTabListBean) it.getSerializableExtra("bean");
        list.clear();
        list.add(baen);
        adqapter = new NerByTabListAdapter(list, this);
        onelist.setAdapter(adqapter);
        ridaogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case 5:
                        allfragmentlin.setVisibility(View.VISIBLE);
//                        alllist.setVisibility(View.VISIBLE);
//                        FragmentManager f = getFragmentManager();
//                        FragmentTransaction t = f.beginTransaction();
//                        FragmentTransaction replace;
//                        replace = t.add(R.id.all_fragment_lin, new NerByAllFragment());
//                        replace.commit();

                        break;
                    case 1:
                        Log.e("11111111111111", "onCheckedChanged: "+"走");
                        tabNum4();
                        allfragmentlin.setVisibility(View.GONE);
                        break;
                    case 2:
                        tabNum4();
                        allfragmentlin.setVisibility(View.GONE);
                        break;
                    case 3:
                        allfragmentlin.setVisibility(View.GONE);
                        tabNum4();

                        break;
                    case 4:
                        tabNum4();
                        allfragmentlin.setVisibility(View.GONE);
                        break;

                }

            }
        });
        alllist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alllist.setVisibility(View.GONE);
                NerByTabListBean item = (NerByTabListBean) adqapter.getItem(position);
                list.clear();
                list.add(item);
                adqapter = new NerByTabListAdapter(list, AerbyItemBaiDuMessageActivity.this);
                onelist.setAdapter(adqapter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "onStop: "+"-----------");
//                onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    public void tabNum4() {
        alllist.setVisibility(View.VISIBLE);
        adqapter = new NerByTabListAdapter(NerByTabListBean.getNerByTabListBeanList(), AerbyItemBaiDuMessageActivity.this);
        alllist.setAdapter(adqapter);
    }

}
