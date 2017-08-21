package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils;

import java.util.Map;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/8/19 15:09
 */
public class NerPrensenter {
     IView iview;

    private static NerPrensenter netp;
    private NerPrensenter (){}

    public static synchronized NerPrensenter getP() {
        if (netp == null) {
            netp = new NerPrensenter();
        }
        return netp;
    }

    public void PgetDate(String url, Map<String, String> map, final IView iview) {
        this.iview = iview;
        NetUtils.getNertUtiles().getLaddeDate(url, map, new NetCall() {
            @Override
            public void Succeed(String str) {
                iview.Successes(str);
            }

            @Override
            public void Err(String str) {
                iview.Errer(str);
            }
        });

    }
}
