package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.example.aensun.leedodoprogect.modle.bean.LoginPhoneBean;
import com.example.aensun.leedodoprogect.modle.bean.PhoneCodeBean;
import com.example.aensun.leedodoprogect.presenter.HttpMethodsPresenter;
import com.example.aensun.leedodoprogect.utils.CheckUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by aensun on 2017-08-15.
 */

public class ReginstersActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "ReginstersActivity";
    @Bind(R.id.register_break)
    ImageView registerBreak;
    @Bind(R.id.ed_register_phone)
    EditText edRegisterPhone;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.ed_register_code)
    EditText edRegisterCode;
    @Bind(R.id.register_obtain)
    Button registerObtain;
    @Bind(R.id.register_password)
    EditText registerPassword;
    @Bind(R.id.register_looks)
    CheckBox registerLooks;
    @Bind(R.id.register_select)
    CheckBox registerSelect;
    @Bind(R.id.register_agreement)
    TextView registerAgreement;
    @Bind(R.id.register_login_btn)
    Button registerLoginBtn;
    @Bind(R.id.register_check)
    TextView registerCheck;
    private String phone;
    private String phoneCode;
    private String passWord;
    int count=60;
    private boolean checkPhone;
    private boolean checkPassWord;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                if(count>0){
                    count--;
                    registerObtain.setText("（"+count+"）秒重新获取");
                    handler.sendEmptyMessageDelayed(0,1000);
                }else{
                    handler.removeMessages(0);
                    count=60;
                    registerObtain.setEnabled(true);
                    registerObtain.setText("获取验证码");
                }

            }
        }
    };
    private boolean isChecked1;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected int setContentViews() {
        return R.layout.reginter_activity;
    }


    @Override
    protected void initData() {
        registerLooks.setOnCheckedChangeListener(this);
        registerLooks.setChecked(true);
        /**
         * 输入框监听事件
         */
        edRegisterPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkPhone = CheckUtils.checkPhoneNumber(s.toString());
                if (checkPhone) {
                    registerCheck.setText("");
                } else {
                    registerCheck.setText("请输入正确的手机格式");
                }
                if(checkPhone&&checkPassWord&&isChecked1){
                    registerLoginBtn.setEnabled(true);
                }else{
                    registerLoginBtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /**
         * 输入框监听事件
         */
        registerPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkPassWord = CheckUtils.checkUsername(s.toString());
                if (checkPassWord) {
                    registerCheck.setText("");
                } else {
                    registerCheck.setText("请输入6-12位字母或数字,不可以有？#* 等特殊符号");
                }
                if(checkPhone&&checkPassWord&&isChecked1){
                    registerLoginBtn.setEnabled(true);
                }else{
                    registerLoginBtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        registerSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isChecked1 = isChecked;
                if(checkPhone&&checkPassWord&&isChecked){
                    registerLoginBtn.setEnabled(true);
                }else{
                    registerLoginBtn.setEnabled(false);
                }

            }
        });

    }


    @OnClick({R.id.register_break, R.id.register_obtain, R.id.register_agreement, R.id.register_login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_break:
                //返回按钮
                finish();
                break;
            case R.id.register_obtain:
                //获取验证码
                getPhoneCodes();
                registerObtain.setEnabled(false);
                handler.sendEmptyMessage(0);
                break;
            case R.id.register_agreement:
                //用户协议

                break;
            case R.id.register_login_btn:
                //登录按钮
                Toast.makeText(ReginstersActivity.this, "点击 ", Toast.LENGTH_SHORT).show();
                getRegisterPhone();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            //
            registerPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            registerPassword.setSelection(registerPassword.length());

        } else {
            registerPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            registerPassword.setSelection(registerPassword.length());
        }

    }

    /**
     * 网络请求获取短信验证码
     */
    public void getPhoneCodes() {
        phone = edRegisterPhone.getText().toString().trim();
        HttpMethodsPresenter.getInstance().getPhoneCode(new Observer<PhoneCodeBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull PhoneCodeBean phoneCodeBean) {
                if (phoneCodeBean != null) {
                    String descirption = phoneCodeBean.getDescirption();
                    Toast.makeText(ReginstersActivity.this, descirption, Toast.LENGTH_SHORT).show();
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
        passWord = registerPassword.getText().toString().trim();
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
                        Toast.makeText(ReginstersActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
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
}
