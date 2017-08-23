package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-15.
 */

public class AboutUsActivity extends BaseActivity {
    @Bind(R.id.about_break)
    ImageView aboutBreak;
    @Bind(R.id.about_us)
    RelativeLayout aboutUs;

    @Override
    protected int setContentViews() {
        return R.layout.aboutus_activity;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.about_break, R.id.about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.about_break:
                finish();
                break;
            case R.id.about_us:
                //用户协议
                break;
        }
    }
}
