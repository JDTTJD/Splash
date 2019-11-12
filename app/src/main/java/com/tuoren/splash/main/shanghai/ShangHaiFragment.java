package com.tuoren.splash.main.shanghai;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.shanghai.adapter.ShanghaiAdapter;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create by JDT on 2019/11/8.
 */

@ViewInject(mainlayoutid = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment {
    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;
    @BindView(R.id.shanghai_collapsingtoolbarlayout)
    CollapsingToolbarLayout shanghaiCollapsingtoolbarlayout;
    @BindView(R.id.shanghai_app_barlayout)
    AppBarLayout shanghaiAppBarlayout;
    @BindView(R.id.shanghai_recyclerview)
    RecyclerView shanghaiRecyclerview;

    @Override
    public void afterBindView() {
        initListener();
        initRecyclerview();
    }

    private void initRecyclerview() {
        shanghaiRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("英雄联盟S10上海市欢迎您");
        }
        shanghaiRecyclerview.setAdapter(new ShanghaiAdapter(data));
    }

    private void initListener() {
        shanghaiAppBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("shanghaiAppBarlayout", "verticalOffset = : " + i + "appBarLayout = " + appBarLayout.getMeasuredHeight());
                if (-i < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
