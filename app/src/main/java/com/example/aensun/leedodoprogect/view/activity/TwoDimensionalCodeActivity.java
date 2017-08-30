package com.example.aensun.leedodoprogect.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aensun.leedodoprogect.R;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitmapUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TwoDimensionalCodeActivity extends BaseActivity {

    @Bind(R.id.twoDimensionalImg)
    ImageView twoDimensionalImg;
    @Bind(R.id.pay_backs)
    RelativeLayout payBacks;

    @Override
    protected int setContentViews() {
        return R.layout.activity_two_dimensional_code;
    }

    @Override
    protected void initData() {
        createTwoDimensionalCode();
    }

    //生成二维码
    public void createTwoDimensionalCode() {
        Bitmap qrCodeBitmap;
        String contentString = "王志龙不靠谱";
        if (!contentString.equals("")) {
            qrCodeBitmap = null;
            try {
                qrCodeBitmap = BitmapUtils.create2DCode(contentString);
            } catch (WriterException e) {
                e.printStackTrace();
            }
            twoDimensionalImg.setImageBitmap(qrCodeBitmap);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.pay_backs)
    public void onViewClicked() {
        finish();
    }
}
