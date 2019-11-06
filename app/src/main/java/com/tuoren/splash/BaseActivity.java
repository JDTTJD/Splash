package com.tuoren.splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Create by JDT on 2019/11/6.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid > 0) {
                setContentView(mainlayoutid);
            } else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        } else {
            throw new RuntimeException("annotation = null");
        }
    }
}
