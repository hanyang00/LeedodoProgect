package com.example.aensun.leedodoprogect.modle.net;

import android.os.Handler;
import android.os.Message;

import com.example.aensun.leedodoprogect.modle.bean.RebateBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 类描述
 * <p>
 * 创建人:商恩东
 * <p>
 * 创建时间 $date$
 */

public class getOkHttpRequest {
    private TransmitDataPort transmitDataPort;
       private  Handler handler = new  Handler() {
               @Override
               public void handleMessage(Message msg) {
                   switch (msg.what){
                       case 0:
                           RebateBean bean=(RebateBean) msg.obj;
                           transmitDataPort.succeed(bean);
                           break;
                       case 1:
                           String error=msg.obj.toString();
                           int Code = msg.arg1;
                           transmitDataPort.error(error,Code);
                       break;

                   }

               }
           };

    public void getNetworkRequest(String url,TransmitDataPort transmitDataPort) {
        this.transmitDataPort=transmitDataPort;
        OkHttpClient client=new OkHttpClient();
        RequestBody  body = new FormBody.Builder()
                .add("status","1")
                .add("token","2dbae1f3fda438301a33e1d0cfd97a34")
                .build();
        Request  request=new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String error=e.getMessage();
                int i = call.hashCode();
                Message message=Message.obtain();
                message.what=1;
                message.arg1=i;
                message.obj=error;
                handler.handleMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson=new Gson();
                RebateBean bean = gson.fromJson(response.body().string(), RebateBean.class);
                Message message=Message.obtain();
                message.what=0;
                message.obj=bean;
                handler.handleMessage(message);

            }
        });
    }
}
