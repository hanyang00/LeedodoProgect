package com.example.aensun.leedodoprogect.view.fragment.NerbyFragments.BeanUtils;

/**
 * 类描述：
 * 创建人：yangyongli
 * 创建时间：2017/8/19 15:12
 */
public interface IView<T>{
    void  Successes(T bean);
    void Errer(String str);
}
