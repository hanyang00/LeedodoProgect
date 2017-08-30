package com.example.aensun.leedodoprogect.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.NearShops;

import java.util.List;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public class HomeHorizontaRecycleAdapter extends RecyclerView.Adapter<HomeHorizontaRecycleAdapter.ViewHolder> {

    Context context;
    List<NearShops.ObjectBean.ListBean> nearList;

    public HomeHorizontaRecycleAdapter(Context context,   List<NearShops.ObjectBean.ListBean> nearList) {
        this.context = context;
        this.nearList = nearList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homehorizontarecycle_item, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(nearList.get(position).shopName);
        Glide.with(context).load(nearList.get(position).picture).into(holder.img);
        holder.near.setText(nearList.get(position).address);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onClickItem.setOnClick(position,nearList.get(position).shopId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nearList != null ? nearList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,near;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.recycle_title);
            near = (TextView) itemView.findViewById(R.id.recycle_near);
            img= (ImageView) itemView.findViewById(R.id.recycle_item_img);

        }
    }
    public interface onClickItem{
        void setOnClick(int position,int shopId);
    }
    onClickItem onClickItem;

    public void HomeHorizontaRecycleAdapter(HomeHorizontaRecycleAdapter.onClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }
}
