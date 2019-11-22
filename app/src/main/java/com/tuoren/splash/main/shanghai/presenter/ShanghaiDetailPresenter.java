package com.tuoren.splash.main.shanghai.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.tuoren.http.result.IResult;
import com.tuoren.splash.base.BasePresenter;
import com.tuoren.splash.base.JHTask;
import com.tuoren.splash.main.shanghai.If.IShanghaiDetailContract;
import com.tuoren.splash.main.shanghai.dto.ShanghaiDetailBean;
import com.tuoren.splash.main.shanghai.module.ShangHaiDetailHttpTask;

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
            /*submitTask(new LfTask() {
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
            });*/
            /*
                架构师的必备条件
                1、合理利用继承关系
                2、合理利用抽象编程
                3、合理利用泛型传递数据
                4、合理利用一些设计模式
             */
            submitTask(new JHTask<ShanghaiDetailBean>() {

                @Override
                public IResult<ShanghaiDetailBean> onBackground() {
                    return new ShangHaiDetailHttpTask<ShanghaiDetailBean>().getXiaoHuaList("desc", "1", "1");
                }

                @Override
                public void onSuccess(IResult<ShanghaiDetailBean> t) {
                    ShanghaiDetailBean data = t.data();
                    // TODO: 2019/11/22 伪代码：临时用，以后进行封装，项目开发不能直接new对象 
                    Gson gson = new Gson();
                    String s = gson.toJson(data);
                    Log.e("ShanghaiDetailPresenter", s);
                }
            });
    }
}
