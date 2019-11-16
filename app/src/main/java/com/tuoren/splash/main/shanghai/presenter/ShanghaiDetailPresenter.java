package com.tuoren.splash.main.shanghai.presenter;

import com.tuoren.splash.base.BasePresenter;
import com.tuoren.splash.main.shanghai.If.IShanghaiDetailContract;
import com.tuoren.splash.main.shanghai.module.ShangHaiDetailHttpTask;
import com.tuoren.task.LfTask;

/**
 * Create by JDT on 2019/11/16.
 */
public class ShanghaiDetailPresenter extends BasePresenter<IShanghaiDetailContract.Iview> implements IShanghaiDetailContract.IPresenter {

    public ShanghaiDetailPresenter(IShanghaiDetailContract.Iview view) {
        super(view);
    }

    @Override
    protected IShanghaiDetailContract.Iview getEmptyView() {
        return IShanghaiDetailContract.emptyView;
    }


    @Override
    public void getNetData() {
        submitTask(new LfTask() {
            @Override
            public void onSuccess(Object o) {
                //获取网络结果
            }

            @Override
            public void onException(Throwable throwable) {

            }

            //运行子线程
            @Override
            public Object onBackground() {
                return new ShangHaiDetailHttpTask().getXiaoHuaList("desc", "1", "2");
            }
        });
    }

}
