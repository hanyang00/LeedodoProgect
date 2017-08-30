package com.example.aensun.leedodoprogect.view.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.utils.GlideImageLoader;
import com.example.aensun.leedodoprogect.view.activity.CityActivity;
import com.example.aensun.leedodoprogect.view.activity.DetailsPageActivity;
import com.example.aensun.leedodoprogect.view.activity.LocationActivity;
import com.example.aensun.leedodoprogect.view.activity.SwitchActivity;
import com.example.aensun.leedodoprogect.view.activity.TwoDimensionalCodeActivity;
import com.example.aensun.leedodoprogect.view.adapters.HomeClassificationViewPagerAdapter;
import com.example.aensun.leedodoprogect.view.adapters.HomeHorizontaRecycleAdapter;
import com.example.aensun.leedodoprogect.view.adapters.NerByTabLayoutFragmentPageAdapter;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.ClassificationFragment_1;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.ClassificationFragment_2;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.NearShops;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.RoundPicBean;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetRespones;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetResponesNearShops;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ISuccessNearShops;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ISuccessView;
import com.google.gson.Gson;
import com.google.zxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by aensun on 2017-08-10.
 */

public class HomePageFragment extends BaseFragment implements ISuccessView, ISuccessNearShops, AMapLocationListener {
    @Bind(R.id.home_banner)
    Banner homeBanner;
    @Bind(R.id.home_viewPager)
    ViewPager homeViewPager;

    //扫一扫
    @Bind(R.id.home_saoyisao)
    ImageView homeSaoyisao;
    //城市列表
    @Bind(R.id.home_city)
    LinearLayout homeCity;
    //消息
    @Bind(R.id.home_naozhong)
    ImageView homeNaozhong;
    //附近旺铺RecycleView
    @Bind(R.id.home_Horizontal_Recycle)
    RecyclerView homeHorizontalRecycle;
    //定位按钮
    @Bind(R.id.home_Location)
    RelativeLayout homeLocation;
    @Bind(R.id.switch_editText)
    EditText switchEditText;
    List<Fragment> fList;

    //小圆点
    List<View> dotList = new ArrayList<>();
    //TabLayout
    @Bind(R.id.home_tablayout)
    TabLayout homeTablayout;
    @Bind(R.id.home_vp)
    ViewPager homeVp;
    @Bind(R.id.img_one)
    ImageView imgOne;
    @Bind(R.id.ime_three)
    ImageView imeThree;
    @Bind(R.id.ime_five)
    ImageView imeFive;
    @Bind(R.id.cityText)
    TextView cityText;

    //轮播图片
    private List<String> roundList;
    private double longitude;
    private double latitude;
    private GetResponesNearShops getResponesNearShops;
    private GetRespones getRespones;


    @Override
    protected View setConnectViews() {
        View view = View.inflate(getActivity(), R.layout.homepage_fragment, null);
        return view;
    }

    @Override
    protected void initData() {

        //分类ViewPager+Fragment
        fList = new ArrayList<>();
        fList.add(new ClassificationFragment_1());
        fList.add(new ClassificationFragment_2());
        dotList.add(getView().findViewById(R.id.dot_1));
        dotList.add(getView().findViewById(R.id.dot_2));

        HomeClassificationViewPagerAdapter adapter = new HomeClassificationViewPagerAdapter(getFragmentManager(), getActivity(), fList);
        homeViewPager.setAdapter(adapter);
        homeViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
             /*   //position脚标
                dotList.get(position).setBackgroundResource(R.drawable.home_dot);
                //将之前的位置更新为不被选中的状态
                dotList.get(oldPosition).setBackgroundResource(R.drawable.home_dot2);
                oldPosition=position;*/
                if (position == 0) {
                    dotList.get(0).setBackgroundResource(R.drawable.home_dot);
                    //将之前的位置更新为不被选中的状态
                    dotList.get(1).setBackgroundResource(R.drawable.home_dot2);
                } else {
                    dotList.get(1).setBackgroundResource(R.drawable.home_dot);
                    //将之前的位置更新为不被选中的状态
                    dotList.get(0).setBackgroundResource(R.drawable.home_dot2);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        /**
         * 记得在该Activity中加android:theme="@style/Base.Theme.AppCompat"权限绑定
         * 指示器颜色
         * 模式
         */
        homeTablayout.setupWithViewPager(homeVp);
        homeTablayout.setTabTextColors(getResources().getColor(R.color.textcolortexta), getResources().getColor(R.color.colorRed));
        homeTablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.backwhite));
        homeTablayout.setTabMode(TabLayout.MODE_FIXED);
        /**
         * 设置适配器
         */
        NerByTabLayoutFragmentPageAdapter adapter1 = new NerByTabLayoutFragmentPageAdapter(getFragmentManager());
        homeVp.setAdapter(adapter1);

        //附近商铺
        Log.e("Longitude", "116.4192930000");
        Log.e("latitude", "39.9768360000");
        Map<String, String> map = new HashMap<>();
        map.put("longitude", "116.4192930000" + longitude);
        map.put("latitude", "39.9768360000" + latitude);
        getResponesNearShops = new GetResponesNearShops(this);
        getResponesNearShops.getNearData("/near/shops", map);

        //轮播图
        Map<String, String> map2 = new HashMap<>();
        map2.put("type", "0");
        getRespones = new GetRespones(this);
        getRespones.getData("/listRecommendPositions", map);


    }

    @Override
    protected void initDataFromServer() {
        locationGaoDe();
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
        getResponesNearShops.deasd();
        dotList.clear();
    }

    //点击事件
    @OnClick({R.id.home_saoyisao, R.id.home_city, R.id.home_Location, R.id.switch_editText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //PopuWindow按钮
            case R.id.home_saoyisao:
                createPopuWindow();
                break;
            //城市列表按钮
            case R.id.home_city:
                Intent it = new Intent(getActivity(), CityActivity.class);
                startActivity(it);
                break;
            //定位
            case R.id.home_Location:
                Intent itLocation = new Intent(getActivity(), LocationActivity.class);
                startActivity(itLocation);
                Snackbar.make(getView(), "定位", Snackbar.LENGTH_SHORT).show();
                break;
            //搜索
            case R.id.switch_editText:
                Intent it2 = new Intent(getActivity(), SwitchActivity.class);
                startActivity(it2);
                break;

        }

    }

    //扫描回传
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("qrcode_result");
        }
    }

    //创建popuWindow
    public void createPopuWindow() {
        final View popView = getActivity().getLayoutInflater().inflate(R.layout.popuwindow_view, null);

        final PopupWindow window = new PopupWindow(popView, (int) getResources().getDimension(R.dimen.sp135), (int) getResources().getDimension(R.dimen.dp106));
        // TODO: 2016/5/17 设置可以获取焦点
        window.setFocusable(true);
        // TODO: 2016/5/17 设置背景颜色
        window.setBackgroundDrawable(new ColorDrawable());
        // TODO: 2016/5/17 设置可以触摸弹出框以外的区域
        window.setOutsideTouchable(true);
        // TODO：更新popupwindow的状态
        window.update();
        // TODO: 2016/5/17 以下拉的方式显示，并且可以设置显示的位置
        window.showAsDropDown(homeSaoyisao, 5, 20);
        //扫描二维码
        popView.findViewById(R.id.pop_SaoyiSao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //6.0权限
                //是否授权
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
                        // 请求授权
//                                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);

                    } else {
                        // 请求授权
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                    }
                } else {
                    camer();
                    Toast.makeText(getActivity(), "已授权", Toast.LENGTH_SHORT).show();
                }
                if (window != null) {
                    window.dismiss();
                }
            }

        });
        //付款码
        popView.findViewById(R.id.pop_PayMa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getActivity(), TwoDimensionalCodeActivity.class);

                startActivity(it);
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "用户授权", Toast.LENGTH_SHORT).show();
                camer();
            } else {
                Toast.makeText(getActivity(), "用户拒绝", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //启动相机
    private void camer() {
        Intent it = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(it, 1);
    }


    //地图返回参数
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {

                longitude = aMapLocation.getLongitude();
                latitude = aMapLocation.getLatitude();

//                Log.e("位置：", aMapLocation.getAddress());
//                Toast.makeText(getActivity(), "" + aMapLocation.getCity(), Toast.LENGTH_SHORT).show();
                //定位城市
                cityText.setText(aMapLocation.getCity());
            } else {
                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }


    public void locationGaoDe() {

        AMapLocationClient mlocationClient;
        //声明mLocationOption对象
        AMapLocationClientOption mLocationOption;
        mlocationClient = new AMapLocationClient(getActivity());
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mlocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient.startLocation();
    }

    @Override
    public void requestSuccessI(String results) {

        Gson gson = new Gson();
        RoundPicBean roundPicBean = gson.fromJson(results, RoundPicBean.class);
        List<RoundPicBean.ObjectBean.ListBean> list = roundPicBean.object.list;
        roundList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String picture = list.get(i).picture;
            roundList.add(picture);
        }
        homeBanner.setImageLoader(new GlideImageLoader());
        homeBanner.setImages(roundList);
        homeBanner.setDelayTime(5000);
        homeBanner.setIndicatorGravity(BannerConfig.CENTER);
        homeBanner.start();


    }

    @Override
    public void requestSuccessNear(String results) {
        Gson gson1 = new Gson();
        NearShops nearShops = gson1.fromJson(results, NearShops.class);
        List<NearShops.ObjectBean.ListBean> nearList = nearShops.object.list;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeHorizontalRecycle.setLayoutManager(layoutManager);
        HomeHorizontaRecycleAdapter adapter2 = new HomeHorizontaRecycleAdapter(getActivity(), nearList);
        homeHorizontalRecycle.setAdapter(adapter2);
        adapter2.HomeHorizontaRecycleAdapter(new HomeHorizontaRecycleAdapter.onClickItem() {
            @Override
            public void setOnClick(int position, int shopId) {
                Intent it = new Intent(getActivity(), DetailsPageActivity.class);
                Log.d("ID------------", shopId + "");
                it.putExtra("shopId", shopId + "");
                startActivity(it);
            }
        });
    }
}



