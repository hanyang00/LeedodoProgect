package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-12.
 */

public class SecuritySettingActivity extends BaseActivity {
    @Bind(R.id.login_break)
    ImageView loginBreak;
    @Bind(R.id.security_password)
    RelativeLayout securityPassword;
    @Bind(R.id.security_payment)
    RelativeLayout securityPayment;
    @Bind(R.id.security_gesture)
    RelativeLayout securityGesture;
    @Bind(R.id.security_replace_phone)
    RelativeLayout securityReplacePhone;

    @Override
    protected int setContentViews() {
        return R.layout.security_setting_activity;
    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.login_break, R.id.security_password, R.id.security_payment, R.id.security_gesture, R.id.security_replace_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_break:
                finish();
                break;
            case R.id.security_password:
                break;
            case R.id.security_payment:
                break;
            case R.id.security_gesture:
                break;
            case R.id.security_replace_phone:
                //更换手机号
                Intent replaceIntent = new Intent(SecuritySettingActivity.this,ReplacePhoneActivity.class);
                startActivity(replaceIntent);
                break;
        }
    }
}
