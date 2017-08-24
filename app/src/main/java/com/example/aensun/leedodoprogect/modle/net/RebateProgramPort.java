package com.example.aensun.leedodoprogect.modle.net;

import com.example.aensun.leedodoprogect.modle.bean.RebateProgramBean;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public interface RebateProgramPort {
    void  succeed(RebateProgramBean clazz);
    void  error(String str,int code);
}
