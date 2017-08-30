package com.example.aensun.leedodoprogect.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.aensun.leedodoprogect.R;

import java.util.ArrayList;


/**
 * @author: xiaolijuan
 * @description:
 * @projectName: SelectCityDome
 * @date: 2016-03-01
 * @time: 17:25
 */
public class CityAdapter extends ArrayAdapter<String> {
    /**
     * 需要渲染的item布局文件
     */
    private int resource;


/*    public CityAdapter(@NonNull Context context, @LayoutRes int resource, List<CityBean.ObjectBean> cityList) {
        super(context, resource, cityList);
        this.resource = resource;
        this.context = context;
        this.cityList = cityList;
    }*/

    public CityAdapter(Context context, int textViewResourceId, ArrayList<String> cityList) {
        super(context,textViewResourceId,cityList);
        resource = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(resource, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        Button name = (Button) layout.findViewById(R.id.tv_city);
        name.setText(getItem(position));
        return layout;
    }
}
