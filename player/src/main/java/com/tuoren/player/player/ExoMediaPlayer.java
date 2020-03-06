package com.tuoren.player.player;

import android.content.Context;
import android.net.Uri;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;
import com.tuoren.player.source.IPlayerSource;
import com.tuoren.player.state.PlayerState;

/**
 * Create by JDT on 2020-02-29.
 */
public class ExoMediaPlayer implements IPlayer, Player.EventListener {


    private IPLayerListener mPlayerListener;
    private final SimpleExoPlayer mExoPlayer;

    public ExoMediaPlayer(Context context) {
        //创建播放器
        mExoPlayer = ExoPlayerFactory.newSimpleInstance(context);
        mExoPlayer.addListener(this);
    }

    @Override
    public void release() {

    }

    @Override
    public void prepare(Context context, IPlayerSource playerSource) {
        DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(playerSource.getResId()));
        RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(context);
        try {
            rawResourceDataSource.open(dataSpec);
        } catch (RawResourceDataSource.RawResourceDataSourceException e) {
            e.printStackTrace();
        }
        Uri uri = rawResourceDataSource.getUri();

        //准备资源去播放
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context,
                Util.getUserAgent(context, ""));
        //github 自带的类
        MediaSource videoSource =
                new ProgressiveMediaSource.Factory(dataSourceFactory)
                        .createMediaSource(uri);
        mExoPlayer.prepare(videoSource);
        mExoPlayer.setPlayWhenReady(true);
        setPlayerState(PlayerState.STARTED);
    }

    @Override
    public void setPlayingListener(IPLayerListener listener) {
        this.mPlayerListener = listener;
    }

    @Override
    public void paused() {
        mExoPlayer.setPlayWhenReady(false);
        setPlayerState(PlayerState.PAUSED);
    }

    @Override
    public void reStart() {
        mExoPlayer.setPlayWhenReady(true);
        setPlayerState(PlayerState.STARTED);
    }

    private void setPlayerState(PlayerState state) {
        if (mPlayerListener != null) {
            mPlayerListener.playerStateChanged(state);
        }
    }
}
