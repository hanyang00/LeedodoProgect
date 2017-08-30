package com.example.aensun.leedodoprogect.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.DetailsPageBean;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.presenter.GetRespones;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.net.view.ISuccessView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailsPageActivity extends BaseActivity implements ISuccessView {


    @Bind(R.id.detailsImg)
    ImageView detailsImg;
    @Bind(R.id.details_shopsName)
    TextView detailsShopsName;
    @Bind(R.id.details_ratingbar)
    RatingBar detailsRatingbar;
    @Bind(R.id.shopDescription)
    TextView detailsshopDescription;
    @Bind(R.id.details_startTime)
    TextView detailsStartTime;
    @Bind(R.id.details_endTime)
    TextView detailsEndTime;
    @Bind(R.id.shop_phone)
    TextView shopPhone;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.details_address)
    TextView detailsAddress;

    @Override
    protected int setContentViews() {
        return R.layout.activity_details_page;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String shopid = intent.getStringExtra("shopId");

        Toast.makeText(this, shopid, Toast.LENGTH_SHORT).show();

        Map<String, String> map = new HashMap<>();
        map.put("shopId", shopid);
        GetRespones getRespones = new GetRespones(this);
        getRespones.getData("/findShopById", map);

    }

    @Override
    public void requestSuccessI(String results) {
        Log.d("商品详情", results);
        Gson gson = new Gson();
        DetailsPageBean detailsPageBean = gson.fromJson(results, DetailsPageBean.class);
        DetailsPageBean.ObjectBean bean = detailsPageBean.object;
        String picture = bean.picture;
        String shopName = bean.shopName;
        String shopDescription = bean.shopDescription;
        String startTime = bean.businessStartTime;
        String endTime = bean.businessEndTime;
        String detailsPhone = bean.phone;

        Glide.with(getApplication()).load(picture).into(detailsImg);
        detailsShopsName.setText(shopName);
        detailsshopDescription.setText(shopDescription);
        detailsStartTime.setText(startTime);
        detailsEndTime.setText(endTime);
        shopPhone.setText(detailsPhone);
        detailsAddress.setText(shopName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_img)
    public void onViewClicked() {

        finish();
    }
}
