package com.example.aensun.leedodoprogect.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.bumptech.glide.Glide;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapters.NerByTabLayoutFragmentPageAdapter;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.RecommendBean;

import java.util.List;

/**
 * Created by aensun on 2017-08-10.
 */

public class NearbyFragment extends BaseFragment {
    /**
     * 声明控件
     */
    TabLayout tab;
    ViewPager vp;
    ImageView imv1, imv2, imv3;
    TextView name1, name2, name3, address1, address2, address3;

    MapView mMapView;
    AMap aMap;
    /**
     * View视图
     */
    private View view;
    @Override
    protected View setConnectViews() {

        view = View.inflate(getActivity(), R.layout.nearby_fragment, null);

        /**
         * 初始化的方法
         */

        initView();

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
        address1 = (TextView) view.findViewById(R.id.nerby_recommend_one_address);
        address2 = (TextView) view.findViewById(R.id.nerby_recommend_two_address);
        address3 = (TextView) view.findViewById(R.id.nerby_recommend_three_address);
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
        mMapView= (MapView) view.findViewById(R.id.map);


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
        vp.setPageTransformer(false,null);
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
        LatLng latLng = new LatLng(33.906901,116.397972);
     /*   MarkerOptions markerOption = new MarkerOptions();
        markerOption.title("西安市").snippet("西安市：34.341568, 108.940174");

        markerOption.draggable(true);//设置Marker可拖动
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                .decodeResource(getResources(),R.mipmap.location)));
        // 将Marker设置为贴地显示，可以双指下拉地图查看效果
        markerOption.setFlat(true);//设置marker平贴地图效果*/

        Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("北京").snippet("点击为北京"));
        LatLng latLng2 = new LatLng(30.341568,116.940174);
        aMap.addMarker(new MarkerOptions().position(latLng2).title("西安").snippet("点击为西安"));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMapView.onCreate(savedInstanceState);

    }

    @Override
    protected void initDataFromServer() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }
}
