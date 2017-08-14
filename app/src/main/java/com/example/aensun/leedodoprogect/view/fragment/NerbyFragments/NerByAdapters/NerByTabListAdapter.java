package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByAdapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.NerByTabListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/14 8:42
 */
public class NerByTabListAdapter extends BaseAdapter {

    private List<NerByTabListBean> list=new ArrayList<>();
    private Context conext;

    public NerByTabListAdapter(List<NerByTabListBean> list, Context conext) {
        this.list = list;
        this.conext = conext;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return convertView;
    }
    class ViewHolder{
        // public NerByTabListBean(String imv, String name, float price, int integral, String addre_distance, String favorable1, int favorable1_imv, String favorable2,int favorable2_imv, int favorable_num) {

        ImageView imv;
        TextView name,price;


    }
}
