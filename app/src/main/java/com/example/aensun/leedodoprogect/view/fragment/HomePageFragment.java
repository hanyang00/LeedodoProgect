package com.example.aensun.leedodoprogect.view.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import com.example.aensun.leedodoprogect.view.activity.LocationActivity;
import com.example.aensun.leedodoprogect.view.activity.SwitchActivity;
import com.example.aensun.leedodoprogect.view.activity.TwoDimensionalCodeActivity;
import com.example.aensun.leedodoprogect.view.adapters.HomeClassificationViewPagerAdapter;
import com.example.aensun.leedodoprogect.view.adapters.HomeHorizontaRecycleAdapter;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.ClassificationFragment_1;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.ClassificationFragment_2;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.TabLayoutFragment;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.RoundPicBean;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetNearShopsResults;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetRoundPicResults;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.INearShopsView;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.IRoundPicView;
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

public class HomePageFragment extends BaseFragment implements INearShopsView, IRoundPicView, AMapLocationListener {
    @Bind(R.id.home_banner)
    Banner homeBanner;
    @Bind(R.id.home_viewPager)
    ViewPager homeViewPager;

    /*  @Bind(R.id.home_tablelayout_ViewPager)
      ViewPager homeTablelayoutViewPager;
      @Bind(R.id.home_tablayou)
      TabLayout homeTablayou;*/
    //扫一扫
    @Bind(R.id.home_saoyisao)
    ImageView homeSaoyisao;
    //城市列表
    @Bind(R.id.home_city_text)
    TextView homeCityText;
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

    //TabLayou
    List<String> tabList;
    List<Fragment> tabviewpagerList = new ArrayList<>();

    //小圆点
    List<View> dotList = new ArrayList<>();


    //轮播图片
    private List<String> roundList;


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


        //TabLayout+ViewPager
        tabList = new ArrayList<>();
        tabList.add("美食");
        tabList.add("休闲娱乐");
        tabList.add("生活服务");
        tabList.add("酒店");
        tabList.add("全部");
        //动态添加TabLayou的Fragment
        for (int i = 0; i < tabList.size(); i++) {
            TabLayoutFragment fragment = new TabLayoutFragment();
            tabviewpagerList.add(fragment);
        }
  /*      homeTablayou.setupWithViewPager(homeTablelayoutViewPager);
        HomeTabLayouViewPagerAdapter adapter1 = new HomeTabLayouViewPagerAdapter(getFragmentManager(), getActivity(), tabviewpagerList, tabList);
        homeTablelayoutViewPager.setAdapter(adapter1);
*/
        //附近商铺
        Map<String, String> map = new HashMap<>();
        map.put("longitude", "116.4192930000");
        map.put("latitude", "39.9768360000");
        GetNearShopsResults getNearShopsResults = new GetNearShopsResults(this);
        getNearShopsResults.getData(map);
        //轮播图
        Map<String, String> map2 = new HashMap<>();
        map2.put("type", "0");
        GetRoundPicResults getRoundPicResults = new GetRoundPicResults(this);
        getRoundPicResults.getRoundPic(map2);

    }

    @Override
    protected void initDataFromServer() {

        AMapLocationClient mlocationClient;
        //声明mLocationOption对象
        AMapLocationClientOption mLocationOption = null;
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

    //点击事件
    @OnClick({R.id.home_saoyisao, R.id.home_city_text, R.id.home_Location, R.id.switch_editText
   })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //PopuWindow按钮
            case R.id.home_saoyisao:
                createPopuWindow();
                break;
            //城市列表按钮
            case R.id.home_city_text:
                Intent it = new Intent(getActivity(), CityActivity.class);
                startActivity(it);
                break;
            //定位
            case R.id.home_Location:
                Intent itLocation = new Intent(getActivity(), LocationActivity.class);
                startActivityForResult(itLocation, 0);
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
            String result = bundle.getString("result");
        }
    }

    //创建popuWindow
    public void createPopuWindow() {
        final View popView = getActivity().getLayoutInflater().inflate(R.layout.popuwindow_view, null);

        final PopupWindow window = new PopupWindow(popView, 270, 212);
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
                Intent openCamera = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(openCamera, 0);
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

    //请求结果
    @Override
    public void requestSuccess(String results) {
        Log.d("NearShops", results.toString());


        //横向RecycleView适配
        List<String> slist = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            slist.add("" + i);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeHorizontalRecycle.setLayoutManager(layoutManager);
        HomeHorizontaRecycleAdapter adapter2 = new HomeHorizontaRecycleAdapter(getActivity(), slist);
        homeHorizontalRecycle.setAdapter(adapter2);

    }


    @Override
    public void roundResults(String results) {
//        Snackbar.make(getView(), results.toString(),Snackbar.LENGTH_LONG);
        Log.e("sssssssss", results.toString());

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
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
//                Log.e("位置：", aMapLocation.getAddress());
                Toast.makeText(getActivity(), "" + aMapLocation.getCity(), Toast.LENGTH_SHORT).show();
                //定位城市
                homeCityText.setText(aMapLocation.getCity());
            } else {
                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

}



