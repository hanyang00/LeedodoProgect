package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils;

import com.google.gson.Gson;

import java.util.Map;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/19 15:09
 */
public class NerPrensenter<T> {
     IView iview;

    private static NerPrensenter netp;
    private NerPrensenter (){}

    public static synchronized NerPrensenter getP() {
        if (netp == null) {
            netp = new NerPrensenter();
        }
        return netp;
    }

    public void PgetDate(String url, Map<String, String> map, final IView iview ,final Class<T> t) {
        this.iview = iview;
        NetUtils.getNertUtiles().getLaddeDate(url, map, new NetCall() {
            @Override
            public void Succeed(String str) {
                Gson gson=new Gson();
                T t1 = gson.fromJson(str, t);
                iview.Successes(t1);
            }

            @Override
            public void Err(String str) {
                iview.Errer(str);
            }
        });

    }
}
