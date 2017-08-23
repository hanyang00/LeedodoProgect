package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-15.
 */

public class MessageUserActivity extends BaseActivity {
    @Bind(R.id.message_break)
    ImageView messageBreak;
    @Bind(R.id.message_recycler)
    RecyclerView messageRecycler;

    @Override
    protected int setContentViews() {
        return R.layout.message_user_activity;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.message_break, R.id.message_recycler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.message_break:
                finish();
                break;
            case R.id.message_recycler:
                break;
        }
    }
}
