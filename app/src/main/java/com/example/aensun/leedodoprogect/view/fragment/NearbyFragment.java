package com.example.aensun.leedodoprogect.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.bumptech.glide.Glide;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapters.NerByTabLayoutFragmentPageAdapter;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.RecommendBean;

import java.util.List;
import com.example.aensun.leedodoprogect.view.adapters.NerByTabLayoutFragmentPageAdapter;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.RecommendBean;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.MyLocationListener;

import java.util.List;

/**
 * Created by aensun on 2017-08-10.
 */





public class NearbyFragment extends BaseFragment {
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();

    /**
     * 声明控件
     */
    TabLayout tab;
    ViewPager vp;
    ImageView imv1, imv2, imv3;
    TextView name1, name2, name3, address1, address2, address3;
    /**
     * View视图
     */
    private View view;

    @Override
    protected View setConnectViews() {
        SDKInitializer.initialize(getActivity().getApplicationContext());
        view = View.inflate(getActivity(), R.layout.nearby_fragment, null);
        /**
         * 初始化的方法
         */
        initView();

        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );
        //注册监听函数
        addGPS(mMapView);
        initLocation();
        initData();
        return view;
    }

    @Override
    protected void initData() {
        /**
         * 控件 id
         */
        vp = (ViewPager) view.findViewById(R.id.berbay_vp);
        tab = (TabLayout) view.findViewById(R.id.nerby_tablayout);
        imv1 = (ImageView) view.findViewById(R.id.nerby_recommend_one_imv);
        imv2 = (ImageView) view.findViewById(R.id.nerby_recommend_two_imv);
        imv3 = (ImageView) view.findViewById(R.id.nerby_recommend_three_imv);
        name1 = (TextView) view.findViewById(R.id.nerby_recommend_one_name);
        name2 = (TextView) view.findViewById(R.id.nerby_recommend_two_name);
        name3 = (TextView) view.findViewById(R.id.nerby_recommend_three_name);
        address1=(TextView) view.findViewById(R.id.nerby_recommend_one_address);
        address2=(TextView) view.findViewById(R.id.nerby_recommend_two_address);
        address3=(TextView) view.findViewById(R.id.nerby_recommend_three_address);
        List<RecommendBean> recommendList = RecommendBean.getRecommendList();
        Glide.with(getActivity()).load(recommendList.get(0).getImv()).into(imv1);
        Glide.with(getActivity()).load(recommendList.get(1).getImv()).into(imv2);
        Glide.with(getActivity()).load(recommendList.get(2).getImv()).into(imv3);
        name1.setText(recommendList.get(0).getName());
        name2.setText(recommendList.get(1).getName());
        name3.setText(recommendList.get(2).getName());
        address1.setText(recommendList.get(0).getAddress());
        address2.setText(recommendList.get(1).getAddress());
        address3.setText(recommendList.get(2).getAddress());

        /**
         * 记得在该Activity中加android:theme="@style/Base.Theme.AppCompat"权限绑定
         * 指示器颜色
         * 模式
         */
        tab.setupWithViewPager(vp);
        tab.setTabTextColors(getResources().getColor(R.color.textcolortexta), getResources().getColor(R.color.colorRed));
        tab.setSelectedTabIndicatorColor(getResources().getColor(R.color.backwhite));
        tab.setTabMode(TabLayout.MODE_FIXED);
        /**
         * 设置适配器
         */
        vp.setAdapter(new NerByTabLayoutFragmentPageAdapter(getFragmentManager()));
    }

    @Override
    protected void initDataFromServer() {

    }
    public void addGPS(View view){
        Toast.makeText(getActivity(),"2",Toast.LENGTH_SHORT).show();
        mLocationClient.start();
    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系
        int priority = option.getPriority();
        Log.e("----------", "initLocation: "+priority );
        int span=0;
        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);

    }

    public void initView() {
        mMapView = (MapView) view.findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
        LocationClient ml=new LocationClient(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在fragment执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在fragment执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在fragment执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

}
