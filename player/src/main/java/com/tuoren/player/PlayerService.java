package com.tuoren.player;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.tuoren.player.player.IPLayerListener;
import com.tuoren.player.player.IPlayer;
import com.tuoren.player.player.PlayerFactory;
import com.tuoren.player.source.IPlayerSource;
import com.tuoren.player.state.PlayerState;

import androidx.annotation.Nullable;

/**
 * Create by JDT on 2019/12/13.
 */
public class PlayerService extends Service implements IPLayerListener {

    private PlayerState mState = PlayerState.IDLE;
    private IPlayer mPlayer;
    private PlayerFactory mPlayerFactory;

    @Override
    public void playerStateChanged(PlayerState state) {
        this.mState = state;
    }

    public class PlayerBinder extends Binder {
        public PlayerService getService() {
            return PlayerService.this;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new PlayerBinder();
    }

    //onStartCommand 在startService有作用 start多次就会调用多次，一般用来给service传递数据
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    //onCreate 不管 start 还是 bind 也不管调用几次 只会启动一次 常用来做去全局舒适化操作
    @Override
    public void onCreate() {
        super.onCreate();
    }

    //播放暂停方法
    public void playOrPause(IPlayerSource playerSource, Context mContext) {
        switch (mState) {
            case IDLE:
                //初始化播放器 去播放
                String url = playerSource.getUrl();
                if (mPlayer != null) {
                    mPlayer.release();
                }
                if (mPlayerFactory == null) {
                    mPlayerFactory = new PlayerFactory();
                }
                if (mPlayer == null) {
                    mPlayer = mPlayerFactory.createPlayer(mContext);
                }
                if (mPlayer == null) {
                    //播放器创建失败
                    return;
                }
                //拿到播放器去播放
                mPlayer.prepare(mContext, url);
                mPlayer.setPlayingListener(this);
                break;
            case STARTED:
                //去暂停
                if (mPlayer != null) {
                    mPlayer.paused();
                }
                break;
            case PAUSED:
                //继续播放
                if (mPlayer != null) {
                    mPlayer.reStart();
                }
                break;
            case PREPARING:
                break;
            default:
                break;
        }
    }
}
