package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-11.
 */

public class LoginActivity extends BaseActivity {

    @Bind(R.id.login_break)
    ImageView loginBreak;
    @Bind(R.id.login_register)
    TextView loginRegister;
    @Bind(R.id.imageView3)
    ImageView imageView3;
    @Bind(R.id.ed_login_phone)
    EditText edLoginPhone;
    @Bind(R.id.imageView5)
    ImageView imageView5;
    @Bind(R.id.ed_login_password)
    EditText edLoginPassword;
    @Bind(R.id.login_looks)
    CheckBox loginLooks;
    @Bind(R.id.login_btn)
    Button loginBtn;
    @Bind(R.id.login_forget_password)
    TextView loginForgetPassword;

    @Override
    protected int setContentViews() {
        return R.layout.login_activity;
    }

    @Override
    protected void initData() {

    }



    @OnClick({R.id.login_break, R.id.login_register, R.id.login_looks, R.id.login_btn, R.id.login_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_break:
                //返回按钮
                finish();
                break;
            case R.id.login_register:
                //跳转注册
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                break;
            case R.id.login_looks:
                //查看密码，隐藏密码
                break;
            case R.id.login_btn:
                //登录按钮

                break;
            case R.id.login_forget_password:
                //忘记密码
                break;
        }
    }
}
