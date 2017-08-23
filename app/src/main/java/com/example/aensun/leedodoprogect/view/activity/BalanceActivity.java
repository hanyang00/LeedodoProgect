package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-15.
 */

public class BalanceActivity extends BaseActivity {
    @Bind(R.id.balance_break)
    ImageView balanceBreak;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.balance_detailed)
    TextView balanceDetailed;
    @Bind(R.id.textView5)
    TextView textView5;
    @Bind(R.id.freeze_balance)
    TextView freezeBalance;
    @Bind(R.id.linearLayout)
    LinearLayout linearLayout;
    @Bind(R.id.available_balance)
    TextView availableBalance;
    @Bind(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @Bind(R.id.balance_looks)
    CheckBox balanceLooks;
    @Bind(R.id.balance_btn)
    Button balanceBtn;

    @Override
    protected int setContentViews() {
        return R.layout.balance_activity;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.balance_break, R.id.balance_detailed, R.id.balance_looks, R.id.balance_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.balance_break:
                finish();
                break;
            case R.id.balance_detailed:
                //余额明细
                break;
            case R.id.balance_looks:
                //显示隐藏
                break;
            case R.id.balance_btn:
                //提现按钮
                break;
        }
    }
}
