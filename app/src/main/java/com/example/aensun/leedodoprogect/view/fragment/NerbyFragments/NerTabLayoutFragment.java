package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.activity.AerbyItemBaiDuMessageActivity;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.NerByTabListBean;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByFragments.NerByTabListAdapter;

/**
 * 类描述：NerTabLayoutFragment
 * 创建人：yangyongli
 * 创建时间：2017/8/12 17:36
 */
public class NerTabLayoutFragment extends Fragment {
//    Thread a;
//    Handler s;
//    TimerTask l;

    /**
     * 全局静态常量
     */
    public static final String KEY1 = "arg";

    /**
     * 控件和视图
     */
    ListView listview;
    private View view;


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
        view = View.inflate(getActivity(), R.layout.nerby_fragment_tabfragment, null);
        listview = (ListView) view.findViewById(R.id.nerby_tab_listview);
        final NerByTabListAdapter adapter = new NerByTabListAdapter(NerByTabListBean.getNerByTabListBeanList(), getActivity());
        listview.setAdapter(adapter);

        /**
         * ViewPager+ViewPager  的 条目点击事件
         */


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item1 = adapter.getItem(position);
                NerByTabListBean bean = (NerByTabListBean) item1;
                Bundle b = new Bundle();
                b.putSerializable("bean", bean);
                //设置跳转页面
                Intent it = new Intent(getActivity(), AerbyItemBaiDuMessageActivity.class);
                it.putExtras(b);
                //跳转
                startActivity(it);
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
        fragment.setArguments(bundle);

        return fragment;
    }

}
