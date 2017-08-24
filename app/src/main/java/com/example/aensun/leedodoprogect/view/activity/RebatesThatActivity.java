package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
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
    @Bind(R.id.particulars_existing)
    TextView particularsExisting;
    @Bind(R.id.particulars_available_amount)
    TextView particularsAvailableAmount;
    @Bind(R.id.slogan)
    TextView slogan;
    @Bind(R.id.picture)
    ImageView picture;

    private String recordCoding;
    private String integral;
    private String integralStyle;

    @Override
    protected int setContentViews() {
        return R.layout.activity_rebates_that;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        recordCoding = intent.getStringExtra("recordCoding");
        integral = intent.getStringExtra("integral");
        integralStyle = intent.getStringExtra("integralStyle");
        String date = intent.getStringExtra("date");

        particularsIssue.setText(recordCoding);
        Glide.with(this).load(integralStyle).into(picture);
        particularsAvailableAmount.setText(integral);
        particularsChangeTheDate.setText(date+"兑换");
    }



    @OnClick(R.id.close)
    public void onViewClicked() {
        finish();
    }
}
