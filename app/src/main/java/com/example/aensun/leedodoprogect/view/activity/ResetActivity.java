package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.modle.bean.KeyBean;
import com.example.aensun.leedodoprogect.view.adapter.KeyboardAdapter;
import com.example.aensun.leedodoprogect.view.adapter.clickontheeventcallbackinterface.KeyOnItemClick;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-25.
 */

public class ResetActivity extends BaseActivity {
    @Bind(R.id.password_break)
    ImageView passwordBreak;
    @Bind(R.id.txt1)
    TextView txt1;
    @Bind(R.id.txt2)
    TextView txt2;
    @Bind(R.id.txt3)
    TextView txt3;
    @Bind(R.id.txt4)
    TextView txt4;
    @Bind(R.id.txt5)
    TextView txt5;
    @Bind(R.id.txt6)
    TextView txt6;
    @Bind(R.id.reset_password_show)
    TextView resetPasswordShow;
    @Bind(R.id.password_btn)
    Button passwordBtn;
    @Bind(R.id.reset_recyclerview)
    RecyclerView resetRecyclerview;
    private List<KeyBean> mList;

    @Override
    protected int setContentViews() {
        return R.layout.reset_activity;
    }

    @Override
    protected void initData() {

        mList = new ArrayList<>();

        mList.add(new KeyBean(1 + ""));
        mList.add(new KeyBean(2 + ""));
        mList.add(new KeyBean(3 + ""));
        mList.add(new KeyBean(4 + ""));
        mList.add(new KeyBean(5 + ""));
        mList.add(new KeyBean(6 + ""));
        mList.add(new KeyBean(7 + ""));
        mList.add(new KeyBean(8 + ""));
        mList.add(new KeyBean(9 + ""));
        mList.add(new KeyBean(""));
        mList.add(new KeyBean(0 + ""));
        mList.add(new KeyBean(""));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        resetRecyclerview.setLayoutManager(gridLayoutManager);
        resetRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        resetRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        KeyboardAdapter keyboardAdapter = new KeyboardAdapter(this, mList);
        keyboardAdapter.setOnClickListeners(new KeyOnItemClick() {
            @Override
            public void onClickListener(View v, int poston) {
                Toast.makeText(ResetActivity.this, mList.get(poston).getKey(), Toast.LENGTH_SHORT).show();
           

            }
        });
        resetRecyclerview.setAdapter(keyboardAdapter);
    }

    @OnClick({R.id.password_break, R.id.password_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.password_break:
                break;
            case R.id.password_btn:
                break;
        }
    }
}
