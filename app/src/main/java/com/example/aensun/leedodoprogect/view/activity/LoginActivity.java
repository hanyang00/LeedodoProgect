package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.aensun.leedodoprogect.presenter.HttpMethodsPresenter;
import com.example.aensun.leedodoprogect.utils.CheckUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by aensun on 2017-08-11.
 */

public class LoginActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "LoginActivity";
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
    @Bind(R.id.login_check)
    TextView loginCheck;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean checkPhone;
    private boolean checkPassWord;

    @Override
    protected int setContentViews() {
        return R.layout.login_activity;
    }

    @Override
    protected void initData() {
        //创建sharedPreferences
        loginStatus();
        loginLooks.setOnCheckedChangeListener(this);
        loginLooks.setChecked(true);
        Intent intent =getIntent();
        String phone = intent.getStringExtra("phone");
        if(phone!=null){
            edLoginPhone.setText(phone);
        }
        /**
         * 输入框监听事件
         */
        edLoginPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               //正则表达式
                checkPhone = CheckUtils.checkPhoneNumber(s.toString());
                if(checkPhone){
                    loginCheck.setText("");
                }else{
                    loginCheck.setText("请输入正确的手机格式");
                }
                if(checkPhone&&checkPassWord){
                    loginBtn.setEnabled(true);
                }else{
                    loginBtn.setEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        /**
         * 输入框监听事件
         */
        edLoginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //正则表达式

                checkPassWord = CheckUtils.checkUsername(s.toString());
                if(checkPassWord){

                    loginCheck.setText("");
                }else{
                    loginCheck.setText("请输入6-12位字母或数字,不可以有？#* 等特殊符号");
                }
                if(checkPhone&&checkPassWord){
                    loginBtn.setEnabled(true);
                }else{
                    loginBtn.setEnabled(false);
                }

            }



            @Override
            public void afterTextChanged(Editable s) {


            }
        });



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


    @OnClick({R.id.login_break, R.id.login_register, R.id.login_looks, R.id.login_btn, R.id.login_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_break:
                //返回按钮
                finish();
                break;
            case R.id.login_register:
                //跳转注册
                Intent registerIntent = new Intent(LoginActivity.this, ReginstersActivity.class);
                startActivityForResult(registerIntent,2);
                break;
            case R.id.login_looks:
                //查看密码，隐藏密码
                break;
            case R.id.login_btn:
                //登录按钮
                loginAsPhone();
                break;
            case R.id.login_forget_password:
                //忘记密码
                //重置登录密码
                Intent replacePassWordIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(replacePassWordIntent);
                finish();
                break;
        }
    }

    /**
     * 网络请求登录
     */
    private void loginAsPhone() {
        String phone = edLoginPhone.getText().toString().trim();
        String passWord = edLoginPassword.getText().toString().trim();
        HttpMethodsPresenter.getInstance().loginPhone(new Observer<LoginPhoneBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull LoginPhoneBean loginPhoneBean) {
                //回传用户信息
                codeIntentUser(loginPhoneBean);
                Toast.makeText(LoginActivity.this, loginPhoneBean.getDescirption(), Toast.LENGTH_SHORT).show();
                Log.d(TAG,loginPhoneBean.toString());
            }


            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, e.getMessage());
                Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {


            }
        }, phone, passWord, 0);
    }


    /**
     * 回传的用户信息进行赋值
     * 保存
     *
     * @param loginPhoneBean
     */
    private void codeIntentUser(LoginPhoneBean loginPhoneBean) {
        Intent intent = getIntent();
        intent.putExtra("phone", loginPhoneBean.getObject().getPhone());
        intent.putExtra("name", loginPhoneBean.getObject().getNickName());
        editor.putBoolean("login",true);
        editor.putString("name",loginPhoneBean.getObject().getNickName());
        editor.putString("phone",loginPhoneBean.getObject().getPhone());
        editor.putString("token",loginPhoneBean.getObject().getToken());
        Log.e(TAG,"/***"+loginPhoneBean.getObject().getToken());
        editor.commit();
        EventBus.getDefault().post("0");
        setResult(2, intent);
        finish();

    }

    /**
     * 返回用户信息
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==1){
            if(requestCode==2){
                String phone = data.getStringExtra("phone");
                String passWord = data.getStringExtra("passWord");
                edLoginPhone.setText(phone);
                edLoginPassword.setText(passWord);
            }

        }
    }


    /**
     * 显示隐藏密码
     * @param buttonView
     * @param isChecked
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            //
            edLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            edLoginPassword.setSelection(edLoginPassword.length());

        }else{
            edLoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            edLoginPassword.setSelection(edLoginPassword.length());
        }
    }
}
