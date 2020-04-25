package com.tuoren.splash.main.beijing.view;

import android.view.View;
import android.widget.TextView;

import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseActivity;
import com.tuoren.splash.base.ViewInject;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_safe)
public class SafeActivity extends BaseActivity {

    @BindView(R.id.tv_xposed)
    TextView mTvXposed;

    @Override
    public void afterBindView() {
        mTvXposed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvXposed.setText(getInfo());
            }
        });
    }

    private String getInfo() {
        return "xposed是我弟弟";
    }
}
