package com.tuoren.player.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

/**
 * Create by JDT on 2019/12/13.
 */
public class GoogleMediaPlayer implements IPlayer, MediaPlayer.OnPreparedListener {

    private MediaPlayer mMediaPlayer;

    public GoogleMediaPlayer() {
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setOnPreparedListener(this);
    }

    @Override
    public void release() {

    }

    @Override
    public void prepare(Context context, String url) {
        //操作MediaPlayer
        // MediaPlayer 播放系统资源时 只能使用uri的方式
        try {
            mMediaPlayer.setDataSource(context, Uri.parse(url));
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        //初始化成功且播放器准备好后 回调
        mp.start();
    }
}
