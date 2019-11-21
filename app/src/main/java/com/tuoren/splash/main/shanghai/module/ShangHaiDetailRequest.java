package com.tuoren.splash.main.shanghai.module;

import com.tuoren.http.request.IRequest;
import com.tuoren.http.annotation.RequestMethod;
import com.tuoren.splash.base.JHRequest;
import com.tuoren.splash.main.shanghai.dto.ShanghaiDetailBean;

/**
 * Create by JDT on 2019/11/15.
 */
public interface ShangHaiDetailRequest {
    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get, ShanghaiDetailBean.class);
}
