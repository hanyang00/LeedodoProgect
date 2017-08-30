package com.example.aensun.leedodoprogect.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.modle.bean.KeyBean;
import com.example.aensun.leedodoprogect.view.adapter.clickontheeventcallbackinterface.KeyOnItemClick;

import java.util.List;

/**
 * Created by aensun on 2017-08-26.
 */

public class KeyboardAdapter extends RecyclerView.Adapter<KeyboardAdapter.ViewHolder> implements View.OnClickListener{

    private Context context;
    private List<KeyBean> list;
    private View view;
    private KeyOnItemClick keyOnItemClick;


    public void setOnClickListeners(KeyOnItemClick keyOnItemClick){
        this.keyOnItemClick=keyOnItemClick;

    }
    public KeyboardAdapter(Context context, List<KeyBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==2){
            view = View.inflate(context, R.layout.keyboard_item,null);
        }else{
            view = View.inflate(context, R.layout.keyboard_item_tow,null);
        }
        view.setOnClickListener(this);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getKey().equals("")){
            return 1;
        }else{
            return 2;
        }


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
            holder.itemView.setTag(position);
            holder.mTextView.setText(list.get(position).getKey());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if(keyOnItemClick!=null){
            keyOnItemClick.onClickListener(v, (Integer) v.getTag());
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_txt);
        }


    }
}
