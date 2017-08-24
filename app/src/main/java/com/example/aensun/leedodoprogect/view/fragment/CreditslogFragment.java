package com.example.aensun.leedodoprogect.view.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapter.CreditslogAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public class CreditslogFragment extends BaseFragment {
    @Bind(R.id.month)
    TextView month;
    @Bind(R.id.credits_log)
    RecyclerView creditsLog;
    private ArrayList<String> list;

    @Override
    protected View setConnectViews() {
        View view = View.inflate(getActivity(), R.layout.creditslog_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        list=new ArrayList<>();
        list.add("1");

    }

    @Override
    protected void initData() {
        CreditslogAdapter adapter=new CreditslogAdapter(getActivity(),list);
        creditsLog.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        creditsLog.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        creditsLog.setAdapter(adapter);
    }

    @Override
    protected void initDataFromServer() {

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
