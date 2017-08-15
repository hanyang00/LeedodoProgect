package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-12.
 */

public class ReplacePhoneActivity extends BaseActivity {
    @Bind(R.id.replace_phone_break)
    ImageView replacePhoneBreak;
    @Bind(R.id.et_replace_new_phone)
    EditText etReplaceNewPhone;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.et_replace_code)
    EditText etReplaceCode;
    @Bind(R.id.et_replace_btn)
    TextView etReplaceBtn;
    @Bind(R.id.et_replace_yes)
    Button etReplaceYes;

    @Override
    protected int setContentViews() {
        return R.layout.replace_phone_activity;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.replace_phone_break, R.id.et_replace_yes})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.replace_phone_break:
                //返回
                finish();
                break;
            case R.id.et_replace_yes:
                //确定
                break;
        }
    }
}
