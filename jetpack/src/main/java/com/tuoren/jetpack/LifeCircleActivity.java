package com.tuoren.jetpack;

import android.os.Bundle;
import android.widget.TextView;

import com.tuoren.jetpack.lifeCircle.LifeCircleViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class LifeCircleActivity extends AppCompatActivity {

    private TextView mTvContent;
    private LifeCircleViewModel lifeCircleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lifeCircleViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(LifeCircleViewModel.class);
        getLifecycle().addObserver(lifeCircleViewModel);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle);
        mTvContent = (TextView) findViewById(R.id.tv_content);

        lifeCircleViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mTvContent.setText(s);
            }
        });
    }
}
