package com.tuoren.ipc.response;

import com.tuoren.ipc.IClientInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Create by JDT on 2020-01-02.
 */
public class ResponseUtil {

    /**
     * 反射调用的类必须在com.ipc.response 包名下面
     * @param requestKey
     * @param requestParams
     * @param mClientInterface
     */
    public static void getAsyncResponse(String requestKey, String requestParams, IClientInterface mClientInterface) {
        StringBuilder stringBuilder = new StringBuilder("com.ipc.response");
        String first = requestKey.substring(0, 1);
        String second = requestKey.substring(1, requestKey.length());
        stringBuilder.append(first.toUpperCase()).append(second).append("Response");
        //通过反射的方式调用的 宿主的类里面
        try {
            Class<?> clazz = Class.forName(stringBuilder.toString());
            Constructor<?> constructor = clazz.getConstructor(String.class, String.class, IClientInterface.class);
            Object object = constructor.newInstance(requestKey, requestParams, mClientInterface);
            Method method = clazz.getMethod(requestKey);
            method.invoke(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
