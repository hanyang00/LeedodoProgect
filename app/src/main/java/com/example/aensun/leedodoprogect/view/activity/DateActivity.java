package com.example.aensun.leedodoprogect.view.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aensun.leedodoprogect.R;
import com.othershe.calendarview.CalendarView;
import com.othershe.calendarview.DateBean;
import com.othershe.calendarview.listener.OnMonthItemClickListener;
import com.othershe.calendarview.listener.OnPagerChangeListener;

import butterknife.Bind;
import butterknife.OnClick;

public class DateActivity extends BaseActivity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.calendar)
    CalendarView calendarView;
    @Bind(R.id.close)
    ImageView close;

    @Override
    protected int setContentViews() {

        return R.layout.activity_date;
    }


    @Override
    protected void initData() {
        calendarView.init();
        DateBean d = calendarView.getDateInit();
        title.setText(d.getSolar()[0] + "年" + d.getSolar()[1] + "月" + d.getSolar()[2] + "日");

        calendarView.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                title.setText(date[0] + "年" + date[1] + "月" + date[2] + "日");
            }
        });

        calendarView.setOnItemClickListener(new OnMonthItemClickListener() {
            @Override
            public void onMonthItemClick(View view, DateBean date) {
                title.setText(date.getSolar()[0] + "年" + date.getSolar()[1] + "月" + date.getSolar()[2] + "日");
            }
        });
    }

    @OnClick(R.id.close)
    public void onViewClicked() {
        finish();
    }
}

