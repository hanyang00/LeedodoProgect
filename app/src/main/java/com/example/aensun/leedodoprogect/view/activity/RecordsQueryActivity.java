package com.example.aensun.leedodoprogect.view.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapter.ViewPagerAndFragmentAdapter;
import com.example.aensun.leedodoprogect.view.fragment.AlreadyRebateFragment;
import com.example.aensun.leedodoprogect.view.fragment.CreditslogFragment;
import com.example.aensun.leedodoprogect.view.fragment.ForRebateFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

public class RecordsQueryActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.close_records_query)
    ImageView closeRecordsQuery;
    @Bind(R.id.credits_log)
    RadioButton creditsLog;
    @Bind(R.id.already_rebate)
    RadioButton alreadyRebate;
    @Bind(R.id.for_rebate)
    RadioButton forRebate;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.radiogroup)
    RadioGroup radiogroup;
    private ArrayList<Fragment> addfragment;
    private AlreadyRebateFragment fragment;
    private CreditslogFragment fragment1;
    private ForRebateFragment fragment2;



    @Override
    protected int setContentViews() {
        return R.layout.activity_records_query;
    }

    @Override
    public void initView() {
        creditsLog.setChecked(true);
    }

    @Override
    protected void initData() {
        addfragment = new ArrayList<>();
        fragment1 = new CreditslogFragment();
        fragment = new AlreadyRebateFragment();
        fragment2 = new ForRebateFragment();
        addfragment.add(fragment1);
        addfragment.add(fragment);
        addfragment.add(fragment2);
        ViewPagerAndFragmentAdapter adapter = new ViewPagerAndFragmentAdapter(getSupportFragmentManager(), addfragment);
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(this);
        radiogroup.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.close_records_query)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
       switch (position){
           case 0:
               creditsLog.setChecked(true);
               break;
           case 1:
               alreadyRebate.setChecked(true);
               break;
           case 2:
               forRebate.setChecked(true);
               break;
       }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        RadioButton radioButton= (RadioButton) group.findViewById(checkedId);
        int i = Integer.parseInt(radioButton.getTag().toString());
        //        选中时viewpager联动
        viewpager.setCurrentItem(i);


    }
}
