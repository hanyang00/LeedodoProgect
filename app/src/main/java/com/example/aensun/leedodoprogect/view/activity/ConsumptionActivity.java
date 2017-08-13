package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-12.
 */

public class ConsumptionActivity extends BaseActivity {
    @Bind(R.id.consump_break)
    ImageView consumpBreak;
    @Bind(R.id.consump_help)
    ImageView consumpHelp;
    @Bind(R.id.consump_recyclerview_content)
    RecyclerView consumpRecyclerviewContent;

    @Override
    protected int setContentViews() {
        return R.layout.consumption_activity;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.consump_break, R.id.consump_help})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.consump_break:
                finish();
                break;
            case R.id.consump_help:
                break;
        }
    }
}
