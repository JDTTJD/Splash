package com.tuoren.splash.main.shanghai.module;

import com.tuoren.http.LfHttpServer;
import com.tuoren.http.result.IResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public class ShangHaiDetailHttpTask extends LfHttpServer {
    public IResult getXiaoHuaList(String sort, String page, String pagesize) {
        Map<String, Object> params = new HashMap<>();
        params.put("sort",sort);
        params.put("page",page);
        params.put("pagesize",pagesize);
        params.put("time","" + System.currentTimeMillis()/1000);
        params.put("key","4fd5a16cadfb5937c361ecf167d9c756");
        return super.execute(ShangHaiDetailRequest.xiaoHuaRequest,params);
    }
}
