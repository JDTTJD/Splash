package com.tuoren.player.player;

import android.content.Context;

import com.tuoren.player.source.IPlayerSource;

/**
 * Create by JDT on 2019/12/13.
 */
public interface IPlayer {

    //播放器释放
    void release();

    void prepare(Context context, IPlayerSource playerSource);

    void setPlayingListener(IPLayerListener listener);

    void paused();

    void reStart();
}
