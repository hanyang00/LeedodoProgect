package com.example.aensun.leedodoprogect.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.adapter.clickontheeventcallbackinterface.MyOnItemclicklistener;

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

public class RebateRecyclerViewAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private ArrayList<String> mlist;
    private Context mcontext;
    private MyOnItemclicklistener onItemclicklistener;
    public void setOnItemclicklistener(MyOnItemclicklistener onItemclicklistener){
        this.onItemclicklistener=onItemclicklistener;
    }

    public RebateRecyclerViewAdapter(ArrayList<String> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext, R.layout.rebate_item, null);
        view.setOnClickListener(this);
        viewholder viewholder = new viewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewholder viewholder = (RebateRecyclerViewAdapter.viewholder) holder;
        viewholder.issue.setText(mlist.get(position));
        viewholder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (mlist.size() < 3) {
            return 3;
        } else if (mlist.size() > 3) {
            return mlist.size();
        } else {
            return 3;
        }
    }

    @Override
    public void onClick(View v) {
    if (onItemclicklistener!=null){
        onItemclicklistener.OnItemclicklistener(v, (int) v.getTag());
    }
    }

    class viewholder extends RecyclerView.ViewHolder {
        @Bind(R.id.issue)
        TextView issue;
        @Bind(R.id.change_the_date)
        TextView changeTheDate;
        @Bind(R.id.existing)
        TextView existing;
        @Bind(R.id.available_amount)
        TextView availableAmount;
        @Bind(R.id.slogan)
        TextView slogan;

        public viewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
