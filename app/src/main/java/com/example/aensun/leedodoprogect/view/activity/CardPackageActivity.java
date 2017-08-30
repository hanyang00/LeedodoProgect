package com.example.aensun.leedodoprogect.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by aensun on 2017-08-24.
 */

public class CardPackageActivity extends BaseActivity {
    @Bind(R.id.card_package_break)
    ImageView cardPackageBreak;
    @Bind(R.id.card_weixin_txt)
    TextView cardWeixinTxt;
    @Bind(R.id.card_weixin_show)
    RelativeLayout cardWeixinShow;
    @Bind(R.id.card_zhifubao_txt)
    TextView cardZhifubaoTxt;
    @Bind(R.id.card_zhifubao_show)
    RelativeLayout cardZhifubaoShow;
    @Bind(R.id.textView6)
    TextView textView6;
    @Bind(R.id.imageView7)
    ImageView imageView7;
    @Bind(R.id.card_yinhang_txt)
    TextView cardYinhangTxt;
    @Bind(R.id.card_yinhang_show)
    RelativeLayout cardYinhangShow;
    @Bind(R.id.card_yinghang_add)
    RelativeLayout cardYinghangAdd;

    @Override
    protected int setContentViews() {
        return R.layout.card_package_activity;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.card_package_break, R.id.card_weixin_show, R.id.card_zhifubao_show, R.id.imageView7, R.id.card_yinhang_show, R.id.card_yinghang_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_package_break:
                break;
            case R.id.card_weixin_show:
                break;
            case R.id.card_zhifubao_show:
                break;
            case R.id.imageView7:
                break;
            case R.id.card_yinhang_show:
                break;
            case R.id.card_yinghang_add:
                break;
        }
    }
}
