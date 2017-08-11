package com.example.aensun.leedodoprogect.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.utils.GlideImageLoader;
import com.example.aensun.leedodoprogect.view.adapters.HomeClassificationViewPagerAdapter;
import com.example.aensun.leedodoprogect.view.adapters.HomeHorizontaRecycleAdapter;
import com.example.aensun.leedodoprogect.view.adapters.HomeTabLayouViewPagerAdapter;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.ClassificationFragment_1;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.ClassificationFragment_2;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.TabLayoutFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by aensun on 2017-08-10.
 */

public class HomePageFragment extends BaseFragment {
    @Bind(R.id.home_banner)
    Banner homeBanner;
    @Bind(R.id.home_viewPager)
    ViewPager homeViewPager;

    @Bind(R.id.home_tablelayout_ViewPager)
    ViewPager homeTablelayoutViewPager;
    private int oldPosition=0;

    @Bind(R.id.home_tablayou)
    TabLayout homeTablayou;
    @Bind(R.id.home_Horizontal_Recycle)
    RecyclerView homeHorizontalRecycle;
    private List<String> imgList;
    List<Fragment> fList;

    //TabLayou
    List<String> tabList;
    List<Fragment> tabviewpagerList = new ArrayList<>();

    //小圆点
    List<View> dotList = new ArrayList<>();

    @Override
    protected View setConnectViews() {
        View view = View.inflate(getActivity(), R.layout.homepage_fragment, null);
        return view;
    }

    @Override
    protected void initData() {
        imgList = new ArrayList<>();
        imgList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3320190108,3284412601&fm=11&gp=0.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502382316832&di=9bf6b3b70c8ca413a5895d9e09eb1092&imgtype=0&src=http%3A%2F%2Fnpic7.edushi.com%2Fcn%2Fzixun%2Fzh-chs%2F2017-01%2F20%2F3738587-20170120162125513.jpg");
        imgList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3320190108,3284412601&fm=11&gp=0.jpg");
        imgList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502382316832&di=9bf6b3b70c8ca413a5895d9e09eb1092&imgtype=0&src=http%3A%2F%2Fnpic7.edushi.com%2Fcn%2Fzixun%2Fzh-chs%2F2017-01%2F20%2F3738587-20170120162125513.jpg");

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
             if (position==0){
                 dotList.get(0).setBackgroundResource(R.drawable.home_dot);
                 //将之前的位置更新为不被选中的状态
                 dotList.get(1).setBackgroundResource(R.drawable.home_dot2);
             }else {
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
        homeTablayou.setupWithViewPager(homeTablelayoutViewPager);
        HomeTabLayouViewPagerAdapter adapter1 = new HomeTabLayouViewPagerAdapter(getFragmentManager(), getActivity(), tabviewpagerList, tabList);
        homeTablelayoutViewPager.setAdapter(adapter1);
        //横向RecycleView适配
        List<String> slist = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            slist.add(""+i);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeHorizontalRecycle.setLayoutManager(layoutManager);
        HomeHorizontaRecycleAdapter adapter2 = new HomeHorizontaRecycleAdapter(getActivity(),slist);
        homeHorizontalRecycle.setAdapter(adapter2);


    }

    @Override
    protected void initDataFromServer() {
        homeBanner.setImageLoader(new GlideImageLoader());
        homeBanner.setImages(imgList);
        homeBanner.setDelayTime(5000);
        homeBanner.setIndicatorGravity(BannerConfig.CENTER);
        homeBanner.start();

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
