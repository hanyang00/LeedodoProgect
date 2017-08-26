package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.activity.AerbyItemBaiDuMessageActivity;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.CommodityListBean;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.IView;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.NerPrensenter;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByFragments.NerByTabListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述：NerTabLayoutFragment
 * 创建人：yangyongli
 * 创建时间：2017/8/12 17:36
 */
public class NerTabLayoutFragment extends Fragment implements IView<CommodityListBean> {
    List<CommodityListBean> beanlist=new ArrayList<>();
    private  NerByTabListAdapter adapter;

    @Override
    public void Successes(CommodityListBean bean) {
        beanlist.add(bean);
          adapter = new NerByTabListAdapter(beanlist, getActivity());
        listview.setAdapter(adapter);
    }

    @Override
    public void Errer(String str) {

    }

    /**
     * 全局静态常量
     */
    public static final String KEY1 = "arg";
    public static final String KEY0 = "arg0";

    /**
     * 控件和视图
     */
    ListView listview;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        /**
         * 接收传过来的信息  操作
         */
        Bundle arguments = getArguments();
        String name = arguments.getString(KEY1);
        String url = arguments.getString(KEY0);
        view = View.inflate(getActivity(), R.layout.nerby_fragment_tabfragment, null);
        listview = (ListView) view.findViewById(R.id.nerby_tab_listview);


        /**
         * 请求网络
         */
        Map<String,String> map=new HashMap<>();
        map.put("shopId","8");
        NerPrensenter.getP().PgetDate(url,map,this,CommodityListBean.class);


        /**
         * ViewPager+ViewPager  的 条目点击事件
         */


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item1 = adapter.getItem(position);
                CommodityListBean bean = (CommodityListBean) item1;
                Bundle b = new Bundle();
                b.putSerializable("bean", bean);
                //设置跳转页面
                Intent it = new Intent(getActivity(), AerbyItemBaiDuMessageActivity.class);
                it.putExtras(b);
                //跳转
                getActivity().startActivity(it);
            }
        });
        return view;
    }

    /**
     * 静态方法  供外界调用  进行不同 Fragment 的使用
     */
    public static Fragment getFragment(String url, String title) {
        /**
         * 实例化Fragment
         * 进行赋值
         * 设置Bundle
         */
        NerTabLayoutFragment fragment = new NerTabLayoutFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY1, title);
        bundle.putString(KEY0, url);
        fragment.setArguments(bundle);

        return fragment;
    }

}
