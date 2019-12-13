package com.tuoren.player.player;

import android.content.Context;

import com.tuoren.player.tool.DataSourceUtil;

/**
 * Create by JDT on 2019/12/13.
 */
public class PlayerFactory {

    /**
     * 一般工厂设计模式：可以创建用户想要的播放器
     * @return
     */
    public IPlayer createPlayer(Context context) {
        //读取配置
        int playerType = DataSourceUtil.getMetaDataFromApp(context);
        switch (playerType) {
            case IPlayerType.MEDIAPLAYERTYPE:
                return new GoogleMediaPlayer();
            default:
                break;
        }
        return null;
    }
}
