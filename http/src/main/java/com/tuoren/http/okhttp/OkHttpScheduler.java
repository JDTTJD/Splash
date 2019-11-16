package com.tuoren.http.okhttp;

import com.tuoren.http.HttpScheduler;
import com.tuoren.http.annotation.RequestMethod;
import com.tuoren.http.request.IRequest;
import com.tuoren.http.request.call.ICall;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Create by JDT on 2019/11/16.
 */
public class OkHttpScheduler extends HttpScheduler {


    private OkHttpClient client;

    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMerhod();
        Request.Builder requestBuilder = new Request.Builder();
        switch (requestMethod) {
            case RequestMethod.Get:
                //拼接GET请求的url host + path
                StringBuilder urlStrBuilder = new StringBuilder(request.getHost().getHost());
                urlStrBuilder.append(request.getPath());
                HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStrBuilder.toString()).newBuilder();
                if (params != null && params.size() > 0) {
                    Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Object> next = iterator.next();
                        // TODO: 2019/11/16 Obj转换为String类型,这里涉及对象如何转成String 字符串
                        urlBuilder.addQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                    }
                }
                requestBuilder.get().url(urlBuilder.build());
                break;
            case RequestMethod.Post:
                // TODO: 2019/11/16 自己完善 
                break;
        }
        Request okHttpRequest = requestBuilder.build();
        Call call = getClient().newCall(okHttpRequest);
        OkHttpCall okHttpCall = new OkHttpCall(request, call);
        return okHttpCall;
    }

    private OkHttpClient getClient() {
        if (client == null) {
            client  = new OkHttpClient();
        }
        return client;
    }
}
