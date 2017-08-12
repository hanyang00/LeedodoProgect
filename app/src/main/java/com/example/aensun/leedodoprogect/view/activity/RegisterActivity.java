package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-11.
 */

public class RegisterActivity extends BaseActivity {

    @Bind(R.id.register_break)
    ImageView registerBreak;
    @Bind(R.id.imageView3)
    ImageView imageView3;
    @Bind(R.id.ed_register_phone)
    EditText edRegisterPhone;
    @Bind(R.id.register_obtain)
    TextView registerObtain;
    @Bind(R.id.imageView5)
    ImageView imageView5;
    @Bind(R.id.ed_register_password)
    EditText edRegisterPassword;
    @Bind(R.id.register_login_btn)
    Button registerLoginBtn;
    @Bind(R.id.register_other)
    TextView registerOther;

    @Override
    protected int setContentViews() {
        return R.layout.register_activity;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.register_break, R.id.register_login_btn, R.id.register_other})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_break:
                finish();
                break;
            case R.id.register_login_btn:

                break;
            case R.id.register_other:
                Toast.makeText(RegisterActivity.this, "其他方式", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}