package com.tuoren.player.player;

import com.tuoren.player.state.PlayerState;

/**
 * Create by JDT on 2019/12/14.
 */
public interface IPLayerListener {

    void playerStateChanged(PlayerState state);

}
