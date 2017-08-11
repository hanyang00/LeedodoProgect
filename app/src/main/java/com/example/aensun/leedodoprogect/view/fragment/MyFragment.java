package com.example.aensun.leedodoprogect.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.activity.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected View setConnectViews() {
        view = View.inflate(getActivity(), R.layout.my_fragment, null);
        ButterKnife.bind(this,view);
        return view;
    }


    @Override
    protected void initData() {
        operationUserNamePhone();

    }

    private void operationUserNamePhone() {
        nowUserName.setVisibility(View.GONE);
        nowUserPhone.setVisibility(View.GONE);
        userName.setVisibility(View.GONE);
        userPhone.setVisibility(View.GONE);
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
                Toast.makeText(getActivity(), "11", Toast.LENGTH_SHORT).show();
                Intent loginIntent =new Intent(getActivity(), LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.user_collection_code:
                break;
            case R.id.user_balance:
                break;
            case R.id.user_card_package:
                break;
            case R.id.user_security_setting:
                break;
            case R.id.user_message:
                break;
            case R.id.user_about_us:
                break;
            case R.id.user_pecords_of_consumption:
                break;
        }
    }
}
