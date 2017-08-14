package com.example.aensun.leedodoprogect.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

}
