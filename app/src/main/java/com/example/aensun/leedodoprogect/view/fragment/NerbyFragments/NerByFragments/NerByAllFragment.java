package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByFragments;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 类描述：
 * 创建人：
 * 创建时间：2017/8/15 8:30
 */
public class NerByAllFragment extends BaseFragment  {

    @Bind(R.id.nerby_tab_all_imv1)
    ImageView imv1;
    @Bind(R.id.nerby_tab_all_gridview1)
    GridView gridview1;
    @Bind(R.id.nerby_tab_all2_imv)
    ImageView imv2;
    @Bind(R.id.nerby_tab_all_gridview2)
    GridView gridview2;

    private List<String> liststr1 = new ArrayList<>();
    private List<String> liststr2 = new ArrayList<>();
    private View view;

    @Override
    protected View setConnectViews() {
        view = View.inflate(getActivity(), R.layout.nerby_tab_all_fragment, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected void initData() {

        Map<String, String> map = new HashMap<>();
        map.put("pageSize", "20");
        map.put("sign", "C7548DE604BCB8A17592EFB9006F9265");
        map.put("gender", "2");
        map.put("ts", "1871746850");
        map.put("page", "1");
        imv2.setImageResource(R.mipmap.lirentubiao);
        imv1.setImageResource(R.mipmap.meishitubiao);

        liststr2.clear();
        liststr1.clear();
        for (int i = 0; i < 3; i++) {
            liststr1.add("火锅");
            liststr1.add("烧烤");
            liststr1.add("粤菜");
            liststr1.add("川菜");
            liststr2.add("美发");
            liststr2.add("美甲");
            liststr2.add("瑜伽");
            liststr2.add("美妆");
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), R.layout.nerby_all_classify_item, R.id.all_classify_text, liststr1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), R.layout.nerby_all_classify_item, R.id.all_classify_text, liststr2);

        gridview1.setAdapter(adapter1);
        gridview2.setAdapter(adapter2);
    }

    @Override
    protected void initDataFromServer() {

    }

}
