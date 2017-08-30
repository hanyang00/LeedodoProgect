package com.example.aensun.leedodoprogect.presenter;

import com.example.aensun.leedodoprogect.modle.bean.RebateProgramBean;
import com.example.aensun.leedodoprogect.modle.net.RebateProgramPort;
import com.example.aensun.leedodoprogect.modle.net.getOKHttpRebateProgram;
import com.example.aensun.leedodoprogect.view.callback.RebateProgramCallback;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public class RebateProgramPresenter {
    private RebateProgramCallback rebateProgramCallback;
    private getOKHttpRebateProgram getOKHttpRebateProgram;

    public RebateProgramPresenter(RebateProgramCallback rebateProgramCallback) {
        this.rebateProgramCallback = rebateProgramCallback;
        getOKHttpRebateProgram=new getOKHttpRebateProgram();
    }
    public  void  getMpty(){
        rebateProgramCallback=null;
    }
    public  void  RebateProgramFragmentPresenter(String url){
        getOKHttpRebateProgram.getNetworkRequest(url, new RebateProgramPort() {
            @Override
            public void succeed(RebateProgramBean clazz) {
                rebateProgramCallback.succeed(clazz);
            }

            @Override
            public void error(String str, int code) {
                rebateProgramCallback.errors(str,code);
            }
        });

    }
}
