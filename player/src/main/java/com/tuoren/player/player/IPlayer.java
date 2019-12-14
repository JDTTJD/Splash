package com.tuoren.player.player;

import android.content.Context;

/**
 * Create by JDT on 2019/12/13.
 */
public interface IPlayer {

    //播放器释放
    void release();

    void prepare(Context context, String url);

    void setPlayingListener(IPLayerListener listener);

    void paused();

    void reStart();
}
