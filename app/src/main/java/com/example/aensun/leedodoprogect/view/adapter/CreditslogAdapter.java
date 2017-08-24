package com.example.aensun.leedodoprogect.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public class CreditslogAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<String> mlist;

    public CreditslogAdapter(Context mContext, ArrayList<String> mlist) {
        this.mContext = mContext;
        this.mlist = mlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.consump_item_recycle, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.shopName.setText(mlist.get(position) +"");

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.shop_name)
        TextView shopName;
        @Bind(R.id.time)
        TextView time;
        @Bind(R.id.consump_money)
        TextView consumpMoney;
        @Bind(R.id.integral)
        TextView integral;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
