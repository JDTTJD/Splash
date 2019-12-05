package com.tuoren.splash.base;

import android.os.Bundle;

import com.tuoren.mvp.mvp.view.LifeCircleMvpActivity;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;

/**
 * Create by JDT on 2019/11/6.
 */
// java jvm 的 五个 存放  的 区域：方法区 堆 栈 程序计数器 本地方法区
// class static 这种是放在方法区
public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            // mainlayoutid这个变量 放在 栈        annotation.mainlayoutid()这个对象是在堆
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0) {
                setContentView(mainlayoutid);
                bindView();
                afterBindView();
            } else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        } else {
            throw new RuntimeException("annotation = null");
        }
    }

    //模版方法设计模式
    public abstract void afterBindView();

    //View 的依赖注入绑定
    private void bindView() {
        ButterKnife.bind(this);
    }
}
