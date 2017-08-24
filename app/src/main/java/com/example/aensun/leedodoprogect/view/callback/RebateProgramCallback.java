package com.example.aensun.leedodoprogect.view.callback;

import com.example.aensun.leedodoprogect.modle.bean.RebateProgramBean;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public interface RebateProgramCallback {
    void  succeed(RebateProgramBean clazz);
    void  errors(String str,int code);
}
