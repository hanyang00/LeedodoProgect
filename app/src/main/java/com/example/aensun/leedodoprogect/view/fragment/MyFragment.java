package com.example.aensun.leedodoprogect.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.activity.ConsumptionActivity;
import com.example.aensun.leedodoprogect.view.activity.LoginActivity;
import com.example.aensun.leedodoprogect.view.activity.SecuritySettingActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aensun on 2017-08-10.
 */

public class MyFragment extends BaseFragment {

    @Bind(R.id.user_breakgrund)
    ImageView userBreakgrund;
    @Bind(R.id.user_now_login)
    TextView userNowLogin;
    @Bind(R.id.user_collection_code)
    ImageView userCollectionCode;
    @Bind(R.id.user_balance)
    ImageView userBalance;
    @Bind(R.id.user_card_package)
    ImageView userCardPackage;
    @Bind(R.id.now_user_name)
    TextView nowUserName;
    @Bind(R.id.now_user_phone)
    TextView nowUserPhone;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.user_phone)
    TextView userPhone;
    @Bind(R.id.user_security_setting)
    RelativeLayout userSecuritySetting;
    @Bind(R.id.user_message)
    RelativeLayout userMessage;
    @Bind(R.id.user_about_us)
    RelativeLayout userAboutUs;
    @Bind(R.id.user_pecords_of_consumption)
    RelativeLayout userPecordsOfConsumption;
    private View view;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private boolean login;

    @Override
    protected View setConnectViews() {
        view = View.inflate(getActivity(), R.layout.my_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    protected void initData() {
        //创建保存登录的状态
        getLoginStatus();
        //显示隐藏用户 手机号
        operationUserNamePhone();

    }

    /**
     * 显示隐藏用户名 手机号，
     * 赋值
     */
    private void operationUserNamePhone() {
        login = sharedPreferences.getBoolean("login", false);
        if (login) {
            String phone = sharedPreferences.getString("phone", "");
            String name = sharedPreferences.getString("name", "");
            String maskNumber = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
            addUser(name, maskNumber);
        } else {
            nowUserName.setVisibility(View.GONE);
            nowUserPhone.setVisibility(View.GONE);
            userName.setVisibility(View.GONE);
            userPhone.setVisibility(View.GONE);
            userNowLogin.setVisibility(View.VISIBLE);
        }
    }

    /**
     *
     * 显示隐藏的方法
     * @param name
     * @param maskNumber
     */
    private void addUser(String name, String maskNumber) {
        userNowLogin.setVisibility(View.GONE);
        nowUserName.setVisibility(View.VISIBLE);
        nowUserPhone.setVisibility(View.VISIBLE);
        userName.setVisibility(View.VISIBLE);
        userPhone.setVisibility(View.VISIBLE);
        userPhone.setText(maskNumber);
        userName.setText(name);
    }

    @Override
    protected void initDataFromServer() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.user_now_login, R.id.user_collection_code, R.id.user_balance, R.id.user_card_package, R.id.user_security_setting, R.id.user_message, R.id.user_about_us, R.id.user_pecords_of_consumption})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.user_now_login:
                //跳转登录
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivityForResult(loginIntent, 1);
                break;
            case R.id.user_collection_code:
                //收款码
                break;
            case R.id.user_balance:
                //余额
                break;
            case R.id.user_card_package:
                //卡包
                break;
            case R.id.user_security_setting:
                //安全设置
                if (login) {
                    Intent securityIntent = new Intent(getActivity(), SecuritySettingActivity.class);
                    startActivity(securityIntent);
                } else {
                    Toast.makeText(getActivity(), "您还没有登录", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.user_message:
                //消息
                if (login) {

                } else {
                    Toast.makeText(getActivity(), "您还没有登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.user_about_us:
                //关于我们
                break;
            case R.id.user_pecords_of_consumption:
                //消费记录跳转详情页
                if (login) {
                    Intent counsumptionIntent = new Intent(getActivity(), ConsumptionActivity.class);
                    startActivity(counsumptionIntent);
                } else {
                    Toast.makeText(getActivity(), "您还没有登录", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 接收回传过来的用户名密码
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2) {
            if (requestCode == 1) {
                String phone = data.getStringExtra("phone");
                String name = data.getStringExtra("name");
                String maskNumber = phone.substring(0, 3) + "****" + phone.substring(7, phone.length());
                addUser(name, maskNumber);
            }
        }
    }

    /**
     * 创建sharedPreferences
     */
    public void getLoginStatus() {
        sharedPreferences = getActivity().getSharedPreferences("user", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    /**
     * 绑定EventBus
     */
    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

    }

    /**
     * 解绑EventBus
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 接收传过来的值
     * @param str
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String str) {
        getLoginStatus();
        operationUserNamePhone();
    }
}
