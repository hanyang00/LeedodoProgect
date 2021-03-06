package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.modle.bean.PhoneCodeBean;
import com.example.aensun.leedodoprogect.presenter.HttpMethodsPresenter;

import butterknife.Bind;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by aensun on 2017-08-11.
 */

public class RegisterActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {


    private static final String TAG = "RegisterActivity";
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
    @Bind(R.id.register_password)
    EditText edRegisterPassword;
    @Bind(R.id.register_login_btn)
    Button registerLoginBtn;
    @Bind(R.id.register_other)
    TextView registerOther;
    @Bind(R.id.register_agreement)
    TextView registerAgreement;
    @Bind(R.id.ed_register_code)
    EditText edRegisterCode;
    @Bind(R.id.register_looks)
    CheckBox registerLooks;
    private String phone;
    private String phoneCode;
    private String passWord;

    @Override
    protected int setContentViews() {
        return R.layout.register_activity;
    }

    @Override
    protected void initData() {
        registerLooks.setOnCheckedChangeListener(this);
        registerLooks.setChecked(true);


    }


    @OnClick({R.id.register_break, R.id.register_login_btn, R.id.register_other, R.id.register_agreement, R.id.register_obtain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_break:
                //返回按钮
                finish();
                break;
            case R.id.register_login_btn:
                //登录按钮
                getRegisterPhone();
                break;
            case R.id.register_obtain:
                //获取验证码
                getPhoneCodes();
                break;
            case R.id.register_other:
                //其他方式登录
                Toast.makeText(RegisterActivity.this, "其他方式", Toast.LENGTH_SHORT).show();
                break;
            case R.id.register_agreement:
                //用户协议

                break;
        }
    }

    public void getPhoneCodes() {
        phone = edRegisterPhone.getText().toString().trim();
        HttpMethodsPresenter.getInstance().getPhoneCode(new Observer<PhoneCodeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PhoneCodeBean phoneCodeBean) {
                if(phoneCodeBean!=null){
                String descirption = phoneCodeBean.getDescirption();
                Toast.makeText(RegisterActivity.this, descirption, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        }, phone, 0, 1);

    }


    public void getRegisterPhone() {
        passWord = edRegisterPassword.getText().toString().trim();
        phoneCode = edRegisterCode.getText().toString().trim();
        HttpMethodsPresenter.getInstance().getRegisterPhone(new Observer<PhoneCodeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PhoneCodeBean phoneCodeBean) {
                Log.d(TAG, phoneCodeBean.getDescirption());
                if (phoneCodeBean != null) {
                    if (phoneCodeBean.getDescirption().equals("系统处理成功")) {
                        Intent intent = getIntent();
                        intent.putExtra("phone", phone);
                        intent.putExtra("passWord", passWord);
                        setResult(1, intent);
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
        }, phone, passWord, phoneCode, 0);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            //
            edRegisterPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            edRegisterPassword.setSelection(edRegisterPassword.length());

        } else {
            edRegisterPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            edRegisterPassword.setSelection(edRegisterPassword.length());
        }

    }
}
