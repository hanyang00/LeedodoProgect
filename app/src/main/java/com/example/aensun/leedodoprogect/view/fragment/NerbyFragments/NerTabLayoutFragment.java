package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.NerByTabListBean;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByAdapters.NerByTabListAdapter;


/**
 * 类描述：NerTabLayoutFragment
 * 创建人：yangyongli
 * 创建时间：2017/8/12 17:36
 */
public class NerTabLayoutFragment extends Fragment {
    /**
     * 全局静态常量
     */
    public static final String KEY1 = "arg";

    /**
     * 控件和视图
     */
    ListView listview;
    private static View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 视图和控件
         */
        /**
         * 接收传过来的信息  操作
         */
        Bundle arguments = getArguments();
        String name = arguments.getString(KEY1);
        //判断是不是全部  的  点击
        if(name.equals("全部")){
            view=View.inflate(getActivity(), R.layout.nerby_tab_all_fragment, null);
        }else{
            view = View.inflate(getActivity(), R.layout.nerby_fragment_tabfragment, null);
            listview=(ListView)view.findViewById(R.id.nerby_tab_listview);
            listview.setAdapter(new NerByTabListAdapter(NerByTabListBean.getNerByTabListBeanList(),getActivity()));
        }
        return view;
    }



    public static Fragment getFragment(String url) {
        /**
         * 实例化Fragment
         * 进行赋值
         * 设置Bundle
         */
        NerTabLayoutFragment fragment = new NerTabLayoutFragment();

        Bundle bundle = new Bundle();


        bundle.putString(KEY1, url);

        fragment.setArguments(bundle);

        return fragment;
    }

}
