package com.example.aensun.leedodoprogect.view.fragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.modle.bean.RebateBean;
import com.example.aensun.leedodoprogect.modle.bean.RebateProgramBean;
import com.example.aensun.leedodoprogect.presenter.RebateFragmentPresenter;
import com.example.aensun.leedodoprogect.presenter.RebateProgramPresenter;
import com.example.aensun.leedodoprogect.utils.AliPay;
import com.example.aensun.leedodoprogect.utils.ScrollViewUtils;
import com.example.aensun.leedodoprogect.view.activity.DateActivity;
import com.example.aensun.leedodoprogect.view.activity.RebatesThatActivity;
import com.example.aensun.leedodoprogect.view.activity.RecordsQueryActivity;
import com.example.aensun.leedodoprogect.view.adapter.RebateRecyclerViewAdapter;
import com.example.aensun.leedodoprogect.view.adapter.clickontheeventcallbackinterface.MyOnItemclicklistener;
import com.example.aensun.leedodoprogect.view.callback.RebateCallback;
import com.example.aensun.leedodoprogect.view.callback.RebateProgramCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;



/**
 * Created by aensun on 2017-08-10.
 */

public class RebateFragment extends BaseFragment implements RebateCallback, RebateProgramCallback, MyOnItemclicklistener {
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
    @Bind(R.id.date)
    LinearLayout date;
    @Bind(R.id.back_to_the_top)
    ImageView backtothetop;
    private ArrayList<RebateProgramBean.ObjectBean> list;
    private View view;
    private RebateRecyclerViewAdapter adapter;
    private static final String TAG = "RebateFragment";
    private int waitCashback;
    private int countReally;
    private int rebatecount;
       private  Handler handler = new  Handler() {
               @Override
               public void handleMessage(Message msg) {
                   int arg1 = msg.arg1;
                   rebateProgram.setText("返利计划  (共 " + arg1 + " 档)");
               }
           };
    private RebateFragmentPresenter presenter;
    private RebateProgramPresenter rebateProgramPresenter;
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM" +
            "/KCxg/OIj6er2GEig0DOkHqBSzEPHGigMbTXP1k2nrxEHeE59xOOuy" +
            "ovQH/A1LgbuVKyOac3uAN4GXIBEoozRVzDhu5dobeNm48BPcpYSAfvN3K" +
            "/5GLacvJeENqsiBx8KufM/9inlHaDRQV7WhX1Oe2ckat1EkdHwxxQgc" +
            "36NhAgMBAAECgYEAwn3sWpq6cUR65LD8h9MIjopTImTlpFjgz72bhsHD" +
            "ZK6A+eJDXcddrwh7DI34t/0IBqu+QEoOc/f0fIEXS9hMwTvFY59XG7M8" +
            "M6SdeaAbemrGmZ1IdD6YDmpbQFHn2ishaYF0YDZIkBS3WLDFrtk/efaar" +
            "BCpGAVXeEiVQE4LewECQQD5W1rpkq+dHDRzzdtdi1bJ479wun5CfmVDV" +
            "b2CJH7Iz0t8zyp/iEVV2QELnxZMphmoSzKaLXutTTj2OImpzCtRAkEA1" +
            "VMxG6nQq9NkU51H1+I3mlUXRZ0XeFA1GFJ7xWpNRAVhEWlDz2zy9v/g" +
            "X+RFpNC3f5uznycas70Xp78ew43TEQJAZFFqi9mlqTF1sLk67bFnIyX" +
            "rGPEOZrXvC13tNfR0xVkQZ4/46wHp0xXQo9pG4GNaoyhNnVV7EkelCPn" +
            "J+HPZYQJAQh6T9QgQZoGR8hyovPAf3dUL7oa/VIo/urcuJ8VIB5JHQNdI" +
            "rk0NjaNHj1E4iNosVgATj3vWWel9IIArb99QkQJAKvfm78lwnImtg5IM6" +
            "04hdn/Wu1XF8tpxsKLWcnfchMr0bM9rCmKmhAY+wdmqSyPZRiNb1QaaaD" +
            "TqJxLy6AnQ+Q==";

    @Override
    protected View setConnectViews() {
        view = View.inflate(getActivity(), R.layout.rebate_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();

    }

    @Override
    protected void initData() {
        adapter = new RebateRecyclerViewAdapter(list, getActivity());
        rebateProgramRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rebateProgramRecyclerview.setAdapter(adapter);
        rebateProgramRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rebateScore.setText(waitCashback + "");
        theRebateAmount.setText(countReally + "");

        adapter.setOnItemclicklistener(this);
        ScrollViewUtils scrollViewUtils = new ScrollViewUtils();
        scrollViewUtils.getscrollview(scrollView, backtothetop);


    }

    @Override
    protected void initDataFromServer() {
        presenter = new RebateFragmentPresenter(this);
        presenter.RebatePresenter("http://123.57.33.185:8088/cashback/countCashback");
        rebateProgramPresenter = new RebateProgramPresenter(this);
        rebateProgramPresenter.RebateProgramFragmentPresenter("http://123.57.33.185:8088///user/cashback/plan");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.back_to_the_top, R.id.The_rebate_amount, R.id.rebate_score, R.id.records_query, R.id.binding_wechat, R.id.binding_alipay, R.id.rebate_program, R.id.show_more, R.id.date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.The_rebate_amount:

                break;
            case R.id.rebate_score:

                break;
            case R.id.records_query:
                Intent jumprecordquery = new Intent(getActivity(), RecordsQueryActivity.class);
                startActivity(jumprecordquery);
                break;
            case R.id.binding_wechat:

                break;
            case R.id.binding_alipay:
                AliPay.Builder alipay=new  AliPay.Builder(getActivity())
                        .setSELLER("8@qdbaiu.com")
                        .setPARTNER("2088901305856832")
                        .setRSA_PRIVATE(RSA_PRIVATE)
                        .setNotifyURL("http://notify.msp.hk/notify.htm")
                        .setOrderTitle("测试商品")
                        .setSubTitle("详情内容")
                        .setPrice("0.01").pay();
//                        .setPayCallBackListener(new AliPay.Builder.PayCallBackListener() {
//                            @Override
//                            public void onPayCallBack(int status, String resultStatus, String progress) {
//                                Toast.makeText(getActivity(),progress,Toast.LENGTH_SHORT).show();
//                                Log.d(TAG, "onPayCallBack: "+progress);
//                            }
//                        });




                break;
            case R.id.rebate_program:

                break;
            case R.id.show_more:
//                initView();
//                adapter.notifyDataSetChanged();
                break;
            case R.id.date:
                Intent jumpcalendar = new Intent(getActivity(), DateActivity.class);
                startActivity(jumpcalendar);
                break;
            case R.id.back_to_the_top:
                if (list.size() > 10) {
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
//                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);滚动到底部
//                        scrollView.fullScroll(ScrollView.FOCUS_UP);滚动到顶部
//
//                        需要注意的是，该方法不能直接被调用
//                        因为Android很多函数都是基于消息队列来同步，所以需要一部操作，
//                        addView完之后，不等于马上就会显示，而是在队列中等待处理，虽然很快，但是如果立即调用fullScroll， view可能还没有显示出来，所以会失败
//                                应该通过handler在新线程中更新
                            scrollView.fullScroll(ScrollView.FOCUS_UP);
                        }
                    });
                }
                    backtothetop.setVisibility(View.GONE);

                break;
        }
    }

    @Override
    public void succeed(RebateBean clazz) {
        waitCashback = clazz.getObject().getWaitCashback();
        countReally = clazz.getObject().getCountReally();

    }

    @Override
    public void succeed(RebateProgramBean clazz) {
        list.addAll(clazz.getObject());
        rebatecount=list.size();
        Message message=Message.obtain();
        message.arg1=rebatecount;
        handler.sendMessage(message);
        Log.i(TAG, "succeed: " + list.size());


        rebateProgramRecyclerview.post(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void errors(String str, int code) {

    }

    @Override
    public void error(String str, int code) {

    }

    //recyclerview点击事件
    @Override
    public void OnItemclicklistener(View view, int position) {
        Intent intent = new Intent(getActivity(), RebatesThatActivity.class);
        intent.putExtra("recordCoding", list.get(position).getRecordCoding());
        intent.putExtra("integral", list.get(position).getIntegral() + "");
        intent.putExtra("integralStyle", list.get(position).getIntegralStyle());
        SimpleDateFormat format=new SimpleDateFormat("yyyy 年 MM 月 dd 日");
        Date d1=new Date(list.get(position).getCashbackSpecificDate());
        String t1=format.format(d1);
        intent.putExtra("date", t1);
        startActivity(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler=null;
        presenter.getMpty();
        rebateProgramPresenter.getMpty();
    }
}
