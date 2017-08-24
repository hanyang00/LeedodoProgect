package com.example.aensun.leedodoprogect.modle.net;

import android.os.Handler;
import android.os.Message;

import com.example.aensun.leedodoprogect.modle.bean.RebateProgramBean;
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

public class getOKHttpRebateProgram {
    private RebateProgramPort rebateProgramPort;
       private  Handler handler = new  Handler() {
               @Override
               public void handleMessage(Message msg) {
                   switch (msg.what){
                       case 0:
                           RebateProgramBean bean=(RebateProgramBean) msg.obj;
                           rebateProgramPort.succeed(bean);
                           break;
                       case 1:
                           String error=msg.obj.toString();
                           int Code = msg.arg1;
                           rebateProgramPort.error(error,Code);
                           break;

                   }

               }
           };

    public void getNetworkRequest(String url,RebateProgramPort rebateProgramPort) {
        this.rebateProgramPort=rebateProgramPort;
        OkHttpClient client=new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("token","faf9105720d000f7bcea972fabb4b518")
                .build();
        Request request=new Request.Builder()
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
                RebateProgramBean bean = gson.fromJson(response.body().string(), RebateProgramBean.class);
                Message message=Message.obtain();
                message.what=0;
                message.obj=bean;
                handler.handleMessage(message);

            }
        });
    }



}
