package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.presenter.MainActivityPresenter;
import com.example.aensun.leedodoprogect.view.fragment.HomePageFragment;
import com.example.aensun.leedodoprogect.view.fragment.MyFragment;
import com.example.aensun.leedodoprogect.view.fragment.NearbyFragment;
import com.example.aensun.leedodoprogect.view.fragment.RebateFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 类描述： MainActivity
 * 创建人：hanshiyang
 * 创建时间：2017/8/10
 */
public class MainActivity extends BaseActivity {


    @Bind(R.id.rb_home)
    RadioButton rbHome;
    @Bind(R.id.rb_nearby)
    RadioButton rbNearby;
    @Bind(R.id.rb_rbate)
    RadioButton rbRbate;
    @Bind(R.id.rb_me)
    RadioButton rbMe;
    private HomePageFragment homePageFragment;
    private NearbyFragment nearbyFragment;
    private RebateFragment rebateFragment;
    private MyFragment myFragment;
    private MainActivityPresenter mainActivityPresenter;
    //    private MainActivityPresenter mainActivityPresenter;
    int flag = 1;

    @Override
    protected int setContentViews() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        ctrateFragment();

    }

    private void ctrateFragment() {
        homePageFragment = new HomePageFragment();
        nearbyFragment = new NearbyFragment();
        rebateFragment = new RebateFragment();
        myFragment = new MyFragment();

        mainActivityPresenter = new MainActivityPresenter(MainActivity.this);
        mainActivityPresenter.dataFragment(homePageFragment);
        rbHome.setChecked(true);
    }


    @OnClick({R.id.rb_home, R.id.rb_nearby, R.id.rb_rbate, R.id.rb_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_home:
                mainActivityPresenter.dataFragment(homePageFragment);
                flag = 1;
                break;
            case R.id.rb_nearby:
                mainActivityPresenter.dataFragment(nearbyFragment);
                flag = 2;
                break;
            case R.id.rb_rbate:
                mainActivityPresenter.dataFragment(rebateFragment);
                flag = 3;
                break;
            case R.id.rb_me:
                mainActivityPresenter.dataFragment(myFragment);
                flag = 4;
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("flag", flag);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            flag = savedInstanceState.getInt("flag");
            if (flag==1){
                mainActivityPresenter.dataFragment(homePageFragment);
            }else if(flag ==2){
                mainActivityPresenter.dataFragment(nearbyFragment);
            }else if(flag ==3){
                mainActivityPresenter.dataFragment(rebateFragment);
            }else if(flag ==4){
                mainActivityPresenter.dataFragment(myFragment);
            }

        }
    }
}
