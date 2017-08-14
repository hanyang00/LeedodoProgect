package com.example.aensun.leedodoprogect.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;
import com.example.aensun.leedodoprogect.view.fragment.homeFragments.beans.CityBean;

import java.util.List;

/**
 * Created by kun on 2016/10/26.
 */
public class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<CityBean.ObjectBean> cities;

    private final int HEAD = 0;
    private final int WORD = 1;
    private final int CITY = 2;

    public CitiesAdapter(Context context, List<CityBean.ObjectBean> cities){
        this.context = context;
        this.cities = cities;
    }

    public List<CityBean.ObjectBean> getData() {
        return cities;
    }

    @Override
    public int getItemCount() {
        int count = 1;
        if(cities==null || cities.size()==0) return count;
        count +=cities.size();
        for(CityBean.ObjectBean datasBean:cities){
            count += cities.size();
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int count = 0;
        if(position==count) return HEAD;//下标为0的固定显示头部布局。

        for(int i = 0; i < cities.size(); i++){
            count++;
            if(position==count){
                return WORD;
            }
            List<CityBean.ObjectBean> addressList = cities;
            for(int j =0;j<addressList.size();j++){
                count++;
                if(position==count){
                    return CITY;
                }
            }
        }
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case HEAD:
                View head = LayoutInflater.from(context).inflate(R.layout.layout_head, parent, false);
                return new HeadViewHolder(head);
            case WORD:
                View word = LayoutInflater.from(context).inflate(R.layout.layout_word, parent, false);
                return new WordViewHolder(word);
            case CITY:
                View city = LayoutInflater.from(context).inflate(R.layout.layout_city, parent, false);
                return new CityViewHolder(city);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int count = 0;
        if(position==count){
            HeadViewHolder headViewHolder = (HeadViewHolder) holder;
        }
        for(int i = 0; i < cities.size(); i++){
            count++;
            if(position==count){
                WordViewHolder wordViewHolder = (WordViewHolder) holder;
                CityBean.ObjectBean datasBean = cities.get(i);
                wordViewHolder.textWord.setText(datasBean.areaname);
            }
            List<CityBean.ObjectBean> addressList = cities;
            for(int j =0;j<addressList.size();j++){
                count++;
                if(position==count){
                    CityViewHolder cityViewHolder = (CityViewHolder) holder;
                   CityBean.ObjectBean addressListBean = addressList.get(j);
                    cityViewHolder.textCity.setText(addressListBean.shortname);
                }
            }
        }

    }


    public static class HeadViewHolder extends RecyclerView.ViewHolder {
        public HeadViewHolder(View view) {
            super(view);
        }
    }
    public static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView textWord;
        public WordViewHolder(View view) {
            super(view);
            textWord = (TextView) view.findViewById(R.id.textWord);
        }
    }
    public static class CityViewHolder extends RecyclerView.ViewHolder {

        TextView textCity;
        public CityViewHolder(View view) {
            super(view);
            textCity = (TextView) view.findViewById(R.id.textCity);
        }
    }
}
