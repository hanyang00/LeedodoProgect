package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.modle.bean.PhoneCodeBean;
import com.example.aensun.leedodoprogect.modle.net.ConstantPool;
import com.example.aensun.leedodoprogect.presenter.HttpMethodsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by aensun on 2017-08-15.
 */

public class ForgotPasswordActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener{
    private static final String TAG = "ForgotPasswordActivity";
    @Bind(R.id.forgot_break)
    ImageView forgotBreak;
    @Bind(R.id.imageView3)
    ImageView imageView3;
    @Bind(R.id.ed_forgot_phone)
    EditText edForgotPhone;
    @Bind(R.id.imageView4)
    ImageView imageView4;
    @Bind(R.id.ed_forgot_password)
    EditText edForgotPassword;
    @Bind(R.id.forgot_getcode)
    Button forgotGetcode;
    @Bind(R.id.imageView5)
    ImageView imageView5;
    @Bind(R.id.ed_forgot_new_password)
    EditText edForgotNewPassword;
    @Bind(R.id.forgot_looks)
    CheckBox forgotLooks;
    @Bind(R.id.imageView6)
    ImageView imageView6;
    @Bind(R.id.ed_forgot_confirm_password)
    EditText edForgotConfirmPassword;
    @Bind(R.id.forgot_btn)
    Button forgotBtn;
    private String phone;
    private String phoneCode;
    private String newPassWord;
    private String phones;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected int setContentViews() {
        return R.layout.forgot_password_activity;
    }

    @Override
    protected void initData() {
        forgotLooks.setOnCheckedChangeListener(this);
        forgotLooks.setChecked(true);
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


    @OnClick({R.id.forgot_break, R.id.forgot_getcode, R.id.forgot_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forgot_break:
                finish();
                break;
            case R.id.forgot_getcode:
                //获取修改密码验证码
                getPhoneCode();
                break;
            case R.id.forgot_btn:
                forgotPassWords();
                break;
        }
    }

    private void forgotPassWords() {
        phones = edForgotPhone.getText().toString().trim();
        phoneCode = edForgotPassword.getText().toString().trim();
        newPassWord = edForgotNewPassword.getText().toString().trim();
        String token = sharedPreferences.getString("token", "");
        Log.i(TAG,phones+"  "+phoneCode+"  " +newPassWord+"  "+token);
        HttpMethodsPresenter.getInstance().forgotPassWord(new Observer<PhoneCodeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PhoneCodeBean phoneCodeBean) {
                Toast.makeText(ForgotPasswordActivity.this, phoneCodeBean.getDescirption(), Toast.LENGTH_SHORT).show();

                Log.i(TAG,phoneCodeBean.toString());
                if(phoneCodeBean!=null){
                    if(phoneCodeBean.getCode().equals("1000")){
                        editor.clear();
                        editor.commit();
                        Toast.makeText(ForgotPasswordActivity.this, "修改成功请重新输入入密码", Toast.LENGTH_SHORT).show();
                        Intent forgotIntent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                        forgotIntent.putExtra("phone",phones);
                        startActivity(forgotIntent);
                        finish();
                    }
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        },phones,phoneCode, token,newPassWord);

    }

    public void getPhoneCode() {
        phone = edForgotPhone.getText().toString().trim();
        HttpMethodsPresenter.getInstance().getPhoneCode(new Observer<PhoneCodeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PhoneCodeBean phoneCodeBean) {
                Toast.makeText(ForgotPasswordActivity.this, phoneCodeBean.getDescirption(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, phone,0,2);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            //
            edForgotNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            edForgotNewPassword.setSelection(edForgotNewPassword.length());
            edForgotConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            edForgotConfirmPassword.setSelection(edForgotConfirmPassword.length());
        }else{
            edForgotNewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            edForgotNewPassword.setSelection(edForgotNewPassword.length());
            edForgotConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            edForgotConfirmPassword.setSelection(edForgotConfirmPassword.length());
        }
    }
}
