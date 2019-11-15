package com.tuoren.http;

import java.util.Map;

/**
 * Create by JDT on 2019/11/15.
 */
public class LfHttpTask {
    protected Object execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }
}
