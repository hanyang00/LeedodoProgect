package com.example.aensun.leedodoprogect.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.ClassificBean;

import java.util.List;

/**
 * date:2017/8/11
 * author:张毛第
 * function:
 */

public class HomeClassificationRecycleAdapter extends RecyclerView.Adapter<HomeClassificationRecycleAdapter.ViewHolder> {


    Context context;
    List<ClassificBean.ObjectBean.ListBean> list;


    public HomeClassificationRecycleAdapter(Context context, List<ClassificBean.ObjectBean.ListBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_classification_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.classificText.setText(list.get(position).categoryName);
        //圆形加载图片
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(position).picture).apply(requestOptions).into(holder.classificImg);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onItemClick.itemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView classificImg;
        TextView classificText;

        public ViewHolder(View itemView) {
            super(itemView);
            classificImg = (ImageView) itemView.findViewById(R.id.classificImg);
            classificText = (TextView) itemView.findViewById(R.id.classificText);
        }
    }

    public interface RecyclesetOnItemClick{
        void itemClick(int position);
    }
    RecyclesetOnItemClick onItemClick;

    public  HomeClassificationRecycleAdapter(RecyclesetOnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
