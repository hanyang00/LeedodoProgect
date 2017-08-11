package com.example.aensun.leedodoprogect.view.callback;

import com.example.aensun.leedodoprogect.modle.bean.RebateBean;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public interface RebateCallback {
    void  succeed(RebateBean clazz);
    void  error(String str,int code);
}
