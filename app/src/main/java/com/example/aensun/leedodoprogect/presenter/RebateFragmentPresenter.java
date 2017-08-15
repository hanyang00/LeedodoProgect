package com.example.aensun.leedodoprogect.presenter;

import com.example.aensun.leedodoprogect.modle.bean.RebateBean;
import com.example.aensun.leedodoprogect.modle.net.TransmitDataPort;
import com.example.aensun.leedodoprogect.modle.net.getOkHttpRequest;
import com.example.aensun.leedodoprogect.view.callback.RebateCallback;


/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public class RebateFragmentPresenter {
    private RebateCallback rebateCallback;
    private getOkHttpRequest getOkHttpRequest;

    public RebateFragmentPresenter(RebateCallback rebateCallback) {
        this.rebateCallback = rebateCallback;
        getOkHttpRequest=new getOkHttpRequest();
    }
    public void  RebatePresenter(String url){
        getOkHttpRequest.getNetworkRequest(url,new TransmitDataPort() {
            @Override
            public void succeed(RebateBean clazz) {
                rebateCallback.succeed(clazz);
            }

            @Override
            public void error(String str, int code) {
                rebateCallback.error(str,code);
            }
        });


    }
}
