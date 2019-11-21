package com.tuoren.http;

import com.tuoren.http.okhttp.OkHttpScheduler;
import com.tuoren.http.request.IRequest;
import com.tuoren.http.request.call.ICall;
import com.tuoren.http.result.IResult;

import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public class HttpHelper {

    private volatile static HttpScheduler httpScheduler;

    public static HttpScheduler getHttpScheduler() {
        if (httpScheduler == null) {
            synchronized (HttpHelper.class) {
                if (httpScheduler == null) {
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }

    // TODO: 2019/11/15  待写真正的网络请求
    protected static <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        request.setParams(params);
        ICall call = getHttpScheduler().newCall(request);
        return getHttpScheduler().execute(call);
    }
}
