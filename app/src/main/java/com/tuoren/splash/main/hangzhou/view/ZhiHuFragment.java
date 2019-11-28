package com.tuoren.splash.main.hangzhou.view;

import android.view.animation.AnimationUtils;

import com.google.android.material.appbar.AppBarLayout;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.hangzhou.adapter.ZhiHuAdapter;
import com.tuoren.splash.main.shanghai.If.IShanghaiDetailContract;
import com.tuoren.splash.main.shanghai.dto.ShanghaiDetailBean;
import com.tuoren.splash.main.shanghai.presenter.ShanghaiDetailPresenter;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create by JDT on 2019/11/25.
 */
@ViewInject(mainlayoutid = R.layout.fragment_zhihu)
public class ZhiHuFragment extends BaseFragment implements IShanghaiDetailContract.Iview {

    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.zhihu_app_barlayout)
    AppBarLayout zhihuAppBarlayout;
    @BindView(R.id.zhihu_recyclerview)
    RecyclerView zhihuRecyclerview;

    @Override
    public void afterBindView() {
        zhihuRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        zhihuRecyclerview.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.zhihu_recyclerview_show));
        mPresenter.getNetData(20);
    }

    @Override
    public void showData(ShanghaiDetailBean data) {
        if (zhihuRecyclerview.getAdapter() == null) {
            ZhiHuAdapter adapter = new ZhiHuAdapter(data.result.data);
            zhihuRecyclerview.setAdapter(adapter);
        }
    }
}
