package com.tuoren.jetpack.navigation;

import android.os.Bundle;

import com.tuoren.jetpack.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Create by JDT on 2020-07-27.
 */
public class NavigationActivity extends AppCompatActivity {
    //1.navigation组件用于单Activity架构，用于不同fragment之间切换
    //2.不需要管理fragmentManager
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }
}
