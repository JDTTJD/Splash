package com.tuoren.player.source;

import java.io.File;

/**
 * Create by JDT on 2019/12/13.
 */
public class RawPlayerSource implements IPlayerSource {

    private String url;
    private int resId;

    //    "android.resource://" + getPackageName() + File.separator + R.raw.audi
    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    public IPlayerSource setPath(String packageName, int rawId) {
        setUrl("android.resource://" + packageName + File.separator + rawId);
        setResId(rawId);
        return this;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
