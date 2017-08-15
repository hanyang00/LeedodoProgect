package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByAdapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils.NerByTabListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/14 8:42
 */
public class NerByTabListAdapter extends BaseAdapter {

    private List<NerByTabListBean> list = new ArrayList<>();
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
        //优化
        ViewHolder holder;
        //判断当前视图是否为空
        if (convertView == null) {
            //实例化 holder 对象
            holder = new ViewHolder();
            //设置视图
            convertView = View.inflate(conext, R.layout.nearby_item_cate, null);
            //为holder类中的属性设置id
            holder.imv = (ImageView) convertView.findViewById(R.id.newby_item_product_imv);
            holder.name = (TextView) convertView.findViewById(R.id.newby_item_product_name);
            holder.price = (TextView) convertView.findViewById(R.id.newby_item_product_price);
            holder.address = (TextView) convertView.findViewById(R.id.newby_item_product_address);
            holder.f_text1 = (TextView) convertView.findViewById(R.id.nerby_item_favorable_one_text);
            holder.f_text2 = (TextView) convertView.findViewById(R.id.nerby_item_favorable_two_text);
            holder.imv_01 = (ImageView) convertView.findViewById(R.id.nerby_item_favorable_one_imv);
            holder.imv_02 = (ImageView) convertView.findViewById(R.id.nerby_item_favorable_two_imv);
            holder.integral = (TextView) convertView.findViewById(R.id.newby_item_product_jifen);
            holder.lin1 = (LinearLayout) convertView.findViewById(R.id.nerby_item_favorable_onelin);
            holder.lin2 = (LinearLayout) convertView.findViewById(R.id.nerby_item_favorable_twolin);
            //设置Tag
            convertView.setTag(holder);
        } else {
            //获取Tag并给holder设置
            holder = (ViewHolder) convertView.getTag();
        }
        //开始赋值
        /**
         * 判断几个优惠
         */
        int num_f = list.get(position).getFavorable_num();

        holder.price.setText(list.get(position).getPrice() + "");
        holder.name.setText(list.get(position).getName() + "");
        holder.address.setText(list.get(position).getAddre_distance() + "");
        holder.integral.setText(list.get(position).getIntegral() + "");
        Glide.with(conext).load(list.get(position).getImv()).into(holder.imv);
        holder.lin1.setVisibility(View.GONE);
        holder.lin2.setVisibility(View.GONE);
        if (num_f == 1) {
            holder.f_text1.setText(list.get(position).getFavorable1() + "");
            Glide.with(conext).load(list.get(position).getFavorable1_imv()).into(holder.imv_01);
            holder.lin1.setVisibility(View.VISIBLE);
        } else if (num_f == 2) {
            holder.f_text1.setText(list.get(position).getFavorable1() + "");
            Glide.with(conext).load(list.get(position).getFavorable1_imv()).into(holder.imv_01);
            holder.f_text2.setText(list.get(position).getFavorable2() + "");
            Glide.with(conext).load(list.get(position).getFavorable2_imv()).into(holder.imv_02);
            holder.lin1.setVisibility(View.VISIBLE);
            holder.lin2.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    class ViewHolder {
        // public NerByTabListBean(String imv, String name, float price, int integral, String addre_distance, String favorable1, int favorable1_imv, String favorable2,int favorable2_imv, int favorable_num) {
        ImageView imv, imv_01, imv_02;
        TextView name, price, address, f_text1, f_text2, integral;
        LinearLayout lin1, lin2;
    }
}
