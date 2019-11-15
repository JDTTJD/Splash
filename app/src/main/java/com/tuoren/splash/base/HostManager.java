package com.tuoren.splash.base;

import com.tuoren.http.request.host.IHost;

/**
 * Create by JDT on 2019/11/15.
 */
public interface HostManager {
    IHost jhHost = new IHost() {

        @Override
        public String getHost() {
            return "http://v.juhe.cn";
        }

        @Override
        public String getDefaultPath() {
            return "/joke/content/list.php";
        }
    };
}
