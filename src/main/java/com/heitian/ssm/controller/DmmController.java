package com.heitian.ssm.controller;

import okhttp3.*;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by kevin on 2017/1/16.
 * 使用这个页面来处理
 */
@Controller
@RequestMapping("/dmm")
public class DmmController {
    @RequestMapping("/showJpg")
    public String showJpg(HttpServletRequest request){
        OkHttpClient  mOkHttpClient=new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url("http://www.baidu.com");
        //可以省略，默认是GET请求
        requestBuilder.method("GET",null);
        Request request1 = requestBuilder.build();
        Call mcall= mOkHttpClient.newCall(request1);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.print("failure ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    System.out.print("wangshu"+ "cache---" + str);
                } else {
                    response.body().string();
                    String str = response.networkResponse().toString();
                    System.out.print("wangshu"+"network---" + str);
                }

            }
        });
        return "image";
    }
}
