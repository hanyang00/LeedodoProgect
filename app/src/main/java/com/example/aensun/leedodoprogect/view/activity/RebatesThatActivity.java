package com.example.aensun.leedodoprogect.view.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.OnClick;

public class RebatesThatActivity extends BaseActivity {


    @Bind(R.id.close)
    ImageView close;
    @Bind(R.id.particulars_issue)
    TextView particularsIssue;
    @Bind(R.id.particulars_change_the_date)
    TextView particularsChangeTheDate;
    @Bind(R.id.slogan)
    TextView slogan;

    @Override
    protected int setContentViews() {
        return R.layout.activity_rebates_that;
    }

    @Override
    protected void initData() {

    }



    @OnClick(R.id.close)
    public void onViewClicked() {
        finish();
    }
}
