package com.example.aensun.leedodoprogect.view.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.modle.bean.RebateBean;
import com.example.aensun.leedodoprogect.presenter.RebateFragmentPresenter;
import com.example.aensun.leedodoprogect.view.adapter.RebateRecyclerViewAdapter;
import com.example.aensun.leedodoprogect.view.callback.RebateCallback;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-10.
 */

public class RebateFragment extends BaseFragment implements RebateCallback {
    @Bind(R.id.The_rebate_amount)
    TextView theRebateAmount;
    @Bind(R.id.rebate_score)
    TextView rebateScore;
    @Bind(R.id.records_query)
    TextView recordsQuery;
    @Bind(R.id.binding_wechat)
    TextView bindingWechat;
    @Bind(R.id.binding_alipay)
    TextView bindingAlipay;
    @Bind(R.id.rebate_program)
    TextView rebateProgram;
    @Bind(R.id.rebate_program_recyclerview)
    RecyclerView rebateProgramRecyclerview;
    @Bind(R.id.scrollView)
    ScrollView scrollView;
    @Bind(R.id.show_more)
    TextView showMore;
    private ArrayList<String> list=new ArrayList<>();
    private View view;
    private RebateRecyclerViewAdapter adapter;
    private static final String TAG = "RebateFragment";
    private int waitCashback;
    private int countReally;

    @Override
    protected View setConnectViews() {
        view = View.inflate(getActivity(), R.layout.rebate_fragment,null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        for (int i = 0; i <3; i++) {
            list.add(i+"");
        }

    }

    @Override
    protected void initData() {
        adapter = new RebateRecyclerViewAdapter(list,getActivity());
        rebateProgramRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rebateProgramRecyclerview.setAdapter(adapter);
        rebateProgramRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        rebateScore.setText(waitCashback+"");
        theRebateAmount.setText(countReally+"");
    }

    @Override
    protected void initDataFromServer() {
        RebateFragmentPresenter presenter=new RebateFragmentPresenter(this);
        presenter.RebatePresenter("http://123.57.33.185:8088/cashback/countCashback");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.The_rebate_amount, R.id.rebate_score, R.id.records_query, R.id.binding_wechat, R.id.binding_alipay, R.id.rebate_program,R.id.show_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.The_rebate_amount:

                break;
            case R.id.rebate_score:

                break;
            case R.id.records_query:

                break;
            case R.id.binding_wechat:

                break;
            case R.id.binding_alipay:

                break;
            case R.id.rebate_program:

                break;
            case  R.id.show_more:
                initView();
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public void succeed(RebateBean clazz) {
        waitCashback = clazz.getObject().getWaitCashback();
        countReally = clazz.getObject().getCountReally();

    }

    @Override
    public void error(String str, int code) {

    }
}
