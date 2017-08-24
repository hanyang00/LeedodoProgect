package com.example.aensun.leedodoprogect.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.aensun.leedodoprogect.R;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitmapUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TwoDimensionalCodeActivity extends BaseActivity {

    @Bind(R.id.twoDimensionalImg)
    ImageView twoDimensionalImg;

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
        String contentString = "22222";
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
}
