package com.example.aensun.leedodoprogect.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SwitchActivity extends BaseActivity {


    @Bind(R.id.history_ListView)
    ListView historyListView;
    @Bind(R.id.relative_back)
    RelativeLayout relativeBack;
    @Bind(R.id.clear_Button)
    Button clearButton;


    @Override
    protected int setContentViews() {
        return R.layout.activity_switch;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.relative_back, R.id.clear_Button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relative_back:
                finish();
                break;
            case R.id.clear_Button:
                Toast.makeText(this, "清空", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
