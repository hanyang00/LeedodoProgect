package com.example.aensun.leedodoprogect.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.modle.bean.PhoneCodeBean;
import com.example.aensun.leedodoprogect.presenter.HttpMethodsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

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
    Button etReplaceBtn;
    @Bind(R.id.et_replace_yes)
    Button etReplaceYes;
    int count=60;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                if(count>0){
                    count--;
                    etReplaceBtn.setText("（"+count+"）秒重新获取");
                    handler.sendEmptyMessageDelayed(0,1000);
                }else{
                    handler.removeMessages(0);
                    count=60;
                    etReplaceBtn.setEnabled(true);
                    etReplaceBtn.setText("获取验证码");
                }

            }
        }
    };
    @Override
    protected int setContentViews() {
        return R.layout.replace_phone_activity;
    }

    @Override
    protected void initData() {
        loginStatus();
    }

    /**
     * 创建sharedPreferences
     * 保存登录状态
     *
     */
    private void loginStatus() {
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }


    @OnClick({R.id.replace_phone_break, R.id.et_replace_yes, R.id.et_replace_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.replace_phone_break:
                //返回
                finish();
                break;
            case R.id.et_replace_yes:
                //确定
                replacePhone();
                break;
            case R.id.et_replace_btn:
                //获取验证码
                getPhoneCode();
                break;

        }
    }

    private void replacePhone() {
        String phone = etReplaceNewPhone.getText().toString().trim();
        String etReplaceCode = this.etReplaceCode.getText().toString().trim();
        String token = sharedPreferences.getString("token", "");
        HttpMethodsPresenter.getInstance().replacePhone(new Observer<PhoneCodeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PhoneCodeBean phoneCodeBean) {
                if(phoneCodeBean.getDescirption().equals("1000")){
                    Toast.makeText(ReplacePhoneActivity.this, phoneCodeBean.getDescirption(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ReplacePhoneActivity.this, phoneCodeBean.getDescirption(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },phone,etReplaceCode,token);


    }

    public void getPhoneCode() {
        etReplaceBtn.setEnabled(false);
        handler.sendEmptyMessage(0);
        String phone = etReplaceNewPhone.getText().toString().trim();
        HttpMethodsPresenter.getInstance().getPhoneCode(new Observer<PhoneCodeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PhoneCodeBean phoneCodeBean) {
            if(phoneCodeBean.getDescirption().equals("1000")){
                Toast.makeText(ReplacePhoneActivity.this, phoneCodeBean.getDescirption(), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(ReplacePhoneActivity.this, phoneCodeBean.getDescirption(), Toast.LENGTH_SHORT).show();
            }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },phone,0,1);
    }
}
