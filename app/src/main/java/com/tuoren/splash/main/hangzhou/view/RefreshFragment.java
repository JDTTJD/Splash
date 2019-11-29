package com.tuoren.splash.main.hangzhou.view;

import com.tuoren.refresh.GodRefreshLayout;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;

import butterknife.BindView;

/**
 * Create by JDT on 2019/11/28.
 */
@ViewInject(mainlayoutid = R.layout.fragment_refresh)
public class RefreshFragment extends BaseFragment {


    @BindView(R.id.god_refresh)
    GodRefreshLayout godRefresh;

    @Override
    public void afterBindView() {
        godRefresh.setRefreshManager();
        godRefresh.setRefreshListener(new GodRefreshLayout.RefreshingListener() {
            @Override
            public void onRefreshing() {
                godRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        godRefresh.refreshOver();
                    }
                },2000);
            }
        });
    }
}
