package com.tuoren.splash.main.shanghai.presenter;

import android.util.Log;

import com.tuoren.http.result.IResult;
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
        //1、数据的结果解析怎么来做
        //2、相同任务的去重工作
            submitTask(new LfTask() {
                //一定要回调到主线程
                @Override
                public void onSuccess(Object o) {
                    //获取网络结果
                    Log.e("getNetData", o.toString());
                }

                @Override
                public void onException(Throwable throwable) {
                    Log.e("getNetData", throwable.toString());
                }

                //运行子线程
                @Override
                public Object onBackground() {
                    IResult desc = new ShangHaiDetailHttpTask().getXiaoHuaList("desc", "1", "2");
                    return desc;
                }
            });
    }
}
