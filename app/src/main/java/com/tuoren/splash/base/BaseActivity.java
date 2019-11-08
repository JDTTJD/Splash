package com.tuoren.splash.base;

import android.os.Bundle;

import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.mvp.view.LifeCircleMvpActivity;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;

/**
 * Create by JDT on 2019/11/6.
 */
public abstract class BaseActivity extends LifeCircleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
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
