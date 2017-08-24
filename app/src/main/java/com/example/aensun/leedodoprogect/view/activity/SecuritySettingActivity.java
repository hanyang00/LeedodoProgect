package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aensun.leedodoprogect.R;

import org.greenrobot.eventbus.EventBus;

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
    @Bind(R.id.security_sign_out)
    Button securitySignOut;
    private SharedPreferences.Editor edit;
    private SharedPreferences sharedPreferences;

    @Override
    protected int setContentViews() {
        return R.layout.security_setting_activity;
    }

    @Override
    protected void initData() {
        loginStatus();

    }

    private void loginStatus() {
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        edit = sharedPreferences.edit();
    }


    @OnClick({R.id.login_break, R.id.security_password, R.id.security_payment, R.id.security_gesture, R.id.security_replace_phone, R.id.security_sign_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_break:
                finish();
                break;
            case R.id.security_password:
                //重置登录密码
                Intent replacePassWordIntent = new Intent(SecuritySettingActivity.this, ForgotPasswordActivity.class);
                startActivity(replacePassWordIntent);
                break;
            case R.id.security_payment:
                break;
            case R.id.security_gesture:
                break;
            case R.id.security_sign_out:
                //退出登录
                edit.clear();
                edit.commit();
                EventBus.getDefault().post("0");
                finish();
                break;
            case R.id.security_replace_phone:
                //更换手机号
                Intent replaceIntent = new Intent(SecuritySettingActivity.this, ReplacePhoneActivity.class);
                startActivity(replaceIntent);
                break;
        }
    }
}
