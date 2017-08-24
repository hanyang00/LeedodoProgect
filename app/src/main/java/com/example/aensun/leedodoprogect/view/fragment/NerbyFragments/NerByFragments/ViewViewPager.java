package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.NerByFragments;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/21 15:33
 */
public class ViewViewPager extends ViewPager{
    public ViewViewPager(Context context) {
        this(context,null);
    }

    public ViewViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //事件分发
    //dispatchTouchEvent->onInterceptTouchEvent->onTouchEvent
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //请求所有父控件及祖宗控件不要拦截事件
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

}
