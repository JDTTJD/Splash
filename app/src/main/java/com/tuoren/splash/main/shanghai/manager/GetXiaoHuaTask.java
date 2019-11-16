package com.tuoren.splash.main.shanghai.manager;

import android.os.AsyncTask;
import android.util.Log;

import com.tuoren.splash.main.shanghai.module.ShangHaiDetailHttpTask;

import java.io.IOException;

import okhttp3.Response;

/**
 * Create by JDT on 2019/11/16.
 */
public class GetXiaoHuaTask extends AsyncTask<Object, Object, Object> {
    //运行在子线程
    @Override
    protected Object doInBackground(Object... objects) {
        Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList((String) objects[0], (String) objects[1], (String) objects[2]);
        return desc;
    }

    //运行在主线程 用于更新数据
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Response response = (Response) o;
        try {
            Log.e("GetXiaoHuaTask", "onResponse + " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
