package com.example.aensun.leedodoprogect.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;

import java.util.List;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public class HomeHorizontaRecycleAdapter extends RecyclerView.Adapter<HomeHorizontaRecycleAdapter.ViewHolder> {

    Context context;
    List<String> sList;

    public HomeHorizontaRecycleAdapter(Context context, List<String> sList) {
        this.context = context;
        this.sList = sList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homehorizontarecycle_item, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(sList.get(position));
        holder.img.setImageResource(R.mipmap.ic_launcher);
        holder.near.setText(sList.get(position));
    }

    @Override
    public int getItemCount() {
        return sList != null ? sList.size() : 0;
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
}
