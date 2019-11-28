package com.tuoren.refresh;

import android.content.Context;
import android.view.View;

/**
 * Create by JDT on 2019/11/28.
 */
public class DefaultRefreshManager extends BaseRefreshManager{
    public DefaultRefreshManager(Context context) {
        super(context);
    }

    @Override
    public View getHeadView() {
        return mLayoutInflater.inflate(R.layout.ulti_header_layout, null, false);
    }
}
