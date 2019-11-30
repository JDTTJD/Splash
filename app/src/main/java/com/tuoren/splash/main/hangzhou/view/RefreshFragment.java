package com.tuoren.splash.main.hangzhou.view;

import com.tuoren.refresh.GodRefreshLayout;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.hangzhou.refresh.MeiTuanRefreshManager;
import com.tuoren.splash.main.shanghai.If.IShanghaiDetailContract;
import com.tuoren.splash.main.shanghai.dto.ShanghaiDetailBean;
import com.tuoren.splash.main.shanghai.presenter.ShanghaiDetailPresenter;

import butterknife.BindView;

/**
 * Create by JDT on 2019/11/28.
 */
@ViewInject(mainlayoutid = R.layout.fragment_refresh)
public class RefreshFragment extends BaseFragment implements IShanghaiDetailContract.Iview {

    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);

    @BindView(R.id.god_refresh)
    GodRefreshLayout godRefresh;
//    @BindView(R.id.refresh_recyclerView)
//    RecyclerView mRecyclerView;

    @Override
    public void afterBindView() {
        initRecyclerView();
        initRefreshLayout();
    }

    private void initRefreshLayout() {
        //1.采用默认的方式
        //godRefresh.setRefreshManager();
        //要支持用户自定义
        godRefresh.setRefreshManager(new MeiTuanRefreshManager(mContext));
        godRefresh.setRefreshListener(new GodRefreshLayout.RefreshingListener() {
            @Override
            public void onRefreshing() {
                //mPresenter.getNetData(1);
                godRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        godRefresh.refreshOver();
                    }
                }, 2000);
            }
        });
    }

    private void initRecyclerView() {
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        mPresenter.getNetData(1);
    }

    @Override
    public void showData(ShanghaiDetailBean data) {
//        if (mRecyclerView.getAdapter() == null) {
//            ZhiHuAdapter adapter = new ZhiHuAdapter(data.result.data);
//            mRecyclerView.setAdapter(adapter);
//        }
//        godRefresh.refreshOver();
    }
}
