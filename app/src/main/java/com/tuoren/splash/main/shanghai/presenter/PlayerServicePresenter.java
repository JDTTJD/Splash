package com.tuoren.splash.main.shanghai.presenter;

import com.tuoren.splash.base.BasePresenter;
import com.tuoren.splash.main.shanghai.If.IPlayerServiceContract;

/**
 * Create by JDT on 2019/11/16.
 */
public class PlayerServicePresenter extends BasePresenter<IPlayerServiceContract.Iview> implements IPlayerServiceContract.IPresenter {

    public PlayerServicePresenter(IPlayerServiceContract.Iview view) {
        super(view);
    }

    @Override
    public void bindService() {

    }

    @Override
    protected IPlayerServiceContract.Iview getEmptyView() {
        return null;
    }
}
