package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils;

import com.example.aensun.leedodoprogect.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/14 8:43
 */
public class NerByTabListBean implements Serializable{
    private String imv;
    private String name;
    private float price;
    private int  integral;
    private String addre_distance;
    private String favorable1;
    private int favorable1_imv;
    private String favorable2;
    private int favorable2_imv;
    private int favorable_num;

    public String getImv() {
        return imv;
    }

    public void setImv(String imv) {
        this.imv = imv;
    }

    public NerByTabListBean(String imv, String name, float price, int integral, String addre_distance, String favorable1, int favorable1_imv, String favorable2,int favorable2_imv, int favorable_num) {
        this.imv = imv;
        this.name = name;
        this.price = price;
        this.integral = integral;
        this.addre_distance = addre_distance;
        this.favorable1 = favorable1;
        this.favorable1_imv = favorable1_imv;
        this.favorable2_imv = favorable2_imv;
        this.favorable2 = favorable2;
        this.favorable_num = favorable_num;
    }

    public int getFavorable2_imv() {
        return favorable2_imv;
    }

    public void setFavorable2_imv(int favorable2_imv) {
        this.favorable2_imv = favorable2_imv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getAddre_distance() {
        return addre_distance;
    }

    public void setAddre_distance(String addre_distance) {
        this.addre_distance = addre_distance;
    }

    public String getFavorable1() {
        return favorable1;
    }

    public void setFavorable1(String favorable1) {
        this.favorable1 = favorable1;
    }

    public int getFavorable1_imv() {
        return favorable1_imv;
    }

    public void setFavorable1_imv(int favorable1_imv) {
        this.favorable1_imv = favorable1_imv;
    }

    public String getFavorable2() {
        return favorable2;
    }

    public void setFavorable2(String favorable2) {
        this.favorable2 = favorable2;
    }

    public int getFavorable_num() {
        return favorable_num;
    }

    public void setFavorable_num(int favorable_num) {
        this.favorable_num = favorable_num;
    }
    public static List<NerByTabListBean> getNerByTabListBeanList(){
        List<NerByTabListBean> list=new ArrayList<>();
        /**
         * https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4223335775,1063260400&fm=200&gp=0.jpg
         * https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1402439043,629126993&fm=26&gp=0.jpg
         * https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3243087890,437030400&fm=26&gp=0.jpg
         * https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3040139092,3657109362&fm=26&gp=0.jpg
         * https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2233964642,154908485&fm=26&gp=0.jpg
         *https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1828792014,1451556483&fm=26&gp=0.jpg
         *public NerByTabListBean(String imv, String name, float price, int integral, String addre_distance, String favorable1, int favorable1_imv, String favorable2, int favorable_num) {
         */

        list.add(new NerByTabListBean("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4223335775,1063260400&fm=200&gp=0.jpg","舌尖上的美食",188.8f,10,"[安贞] 距您 <100m",null,0,null,0,0));
        list.add(new NerByTabListBean("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1402439043,629126993&fm=26&gp=0.jpg","小可爱的西点",166.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,null,0,1));
        list.add(new NerByTabListBean("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3243087890,437030400&fm=26&gp=0.jpg","给力给力给力餐",366.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,"情侣半价",R.mipmap.youhui2,2));
        list.add(new NerByTabListBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3040139092,3657109362&fm=26&gp=0.jpg","舌尖上的美食",188.8f,10,"[安贞] 距您 <100m",null,0,null,0,0));
        list.add(new NerByTabListBean("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2233964642,154908485&fm=26&gp=0.jpg","小可爱的西点",166.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,null,0,1));
        list.add(new NerByTabListBean("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1828792014,1451556483&fm=26&gp=0.jpg","给力给力给力餐",366.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,"情侣半价",R.mipmap.youhui2,2));
        list.add(new NerByTabListBean("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4223335775,1063260400&fm=200&gp=0.jpg","舌尖上的美食",188.8f,10,"[安贞] 距您 <100m",null,0,null,0,0));
        list.add(new NerByTabListBean("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1402439043,629126993&fm=26&gp=0.jpg","小可爱的西点",166.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,null,0,1));
        list.add(new NerByTabListBean("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3243087890,437030400&fm=26&gp=0.jpg","给力给力给力餐",366.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,"情侣半价",R.mipmap.youhui2,2));
        list.add(new NerByTabListBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3040139092,3657109362&fm=26&gp=0.jpg","舌尖上的美食",188.8f,10,"[安贞] 距您 <100m",null,0,null,0,0));
        list.add(new NerByTabListBean("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2233964642,154908485&fm=26&gp=0.jpg","小可爱的西点",166.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,null,0,1));
        list.add(new NerByTabListBean("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1828792014,1451556483&fm=26&gp=0.jpg","给力给力给力餐",366.8f,10,"[安贞] 距您 <100m","每满100减12", R.mipmap.youhui1,"情侣半价",R.mipmap.youhui2,2));

        return list;

    }

    @Override
    public String toString() {
        return "NerByTabListBean{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", integral=" + integral +
                ", addre_distance='" + addre_distance + '\'' +
                ", favorable1='" + favorable1 + '\'' +
                ", favorable1_imv=" + favorable1_imv +
                ", favorable2='" + favorable2 + '\'' +
                ", favorable_num=" + favorable_num +
                '}';
    }
}
