package com.tuoren.splash.main.shanghai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.base.tools.AnimationUtil;
import com.tuoren.splash.base.tools.DoubleClickListener;
import com.tuoren.splash.main.shanghai.If.IPlayerServiceContract;
import com.tuoren.splash.main.shanghai.adapter.ShanghaiAdapter2;
import com.tuoren.splash.main.shanghai.presenter.PlayerServicePresenter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create by JDT on 2019/11/8.
 */

@ViewInject(mainlayoutid = R.layout.fragment_shanghai)
public class ShangHaiFragment extends BaseFragment implements IPlayerServiceContract.Iview {

    IPlayerServiceContract.IPresenter mPresenter = new PlayerServicePresenter(this);
    @BindView(R.id.tv_shanghai_welcome)
    TextView tvShanghaiWelcome;
    @BindView(R.id.shanghai_collapsingtoolbarlayout)
    CollapsingToolbarLayout shanghaiCollapsingtoolbarlayout;
    @BindView(R.id.shanghai_app_barlayout)
    AppBarLayout shanghaiAppBarlayout;
    @BindView(R.id.shanghai_recyclerview)
    RecyclerView shanghaiRecyclerview;
    @BindView(R.id.tv_marquee_title)
    TextView mTvTitle;
    @BindView(R.id.shanghai_iv_bg)
    ImageView mIvBg;
    private boolean mIsPlaying;

    @Override
    public void afterBindView() {
        initView();
        initListener();
        initRecyclerview();
    }

    private void initView() {
        RequestOptions cropOptions = new RequestOptions().centerCrop();
        //feature_gao2
        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1602760026111&di=a6a851b97be90627b6be6eb100845e02&imgtype=0&src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ftuangou%2F228%2F918%2F142%2F6e43d43424644890b3feb911efc2f8d3_720_480_s.jpg")
                .fitCenter()
                .placeholder(R.mipmap.shanghai)
                .apply(cropOptions)
                .into(mIvBg);
    }

    private void initRecyclerview() {
        shanghaiRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
//        shanghaiRecyclerview.setAdapter(new ShanghaiAdapter(getActivity(), ShanghaiDataManager.getData(),false));
        shanghaiRecyclerview.setAdapter(new ShanghaiAdapter2());
    }

    private void initListener() {
        shanghaiAppBarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("shanghaiAppBarlayout", "verticalOffset = : " + i + "appBarLayout = " + appBarLayout.getMeasuredHeight());
                if (-i < appBarLayout.getMeasuredHeight() / 2) {
                    tvShanghaiWelcome.setVisibility(View.INVISIBLE);
                    mTvTitle.setVisibility(View.INVISIBLE);
                } else {
                    tvShanghaiWelcome.setVisibility(View.VISIBLE);
                    if (mIsPlaying) {
                        mTvTitle.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        tvShanghaiWelcome.setOnClickListener(new DoubleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.clearAnimation();
                tvShanghaiWelcome.clearAnimation();
                if (mIsPlaying) {
                    //关闭音视频动画
                    mTvTitle.setVisibility(View.GONE);
                    AnimationUtil.startTranslationXAnim(tvShanghaiWelcome, tvShanghaiWelcome.getTranslationX(),
                            tvShanghaiWelcome.getTranslationX() + 100, null);
                    AnimationUtil.startTranslationXAnim(mTvTitle, mTvTitle.getTranslationX(),
                            mTvTitle.getTranslationX() + 100, null);
                    mPresenter.playOrPaused();

                } else {
                    //播放音视频动画
                    AnimationUtil.startTranslationXAnim(tvShanghaiWelcome, tvShanghaiWelcome.getTranslationX(),
                            tvShanghaiWelcome.getTranslationX() - 100, null);
                    AnimationUtil.startTranslationXAnim(mTvTitle, mTvTitle.getTranslationX(),
                            mTvTitle.getTranslationX() - 100, new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    mTvTitle.setVisibility(View.VISIBLE);
                                    // 启动service 去 播放后台音乐
                                    mPresenter.bindService(mContext);
                                }
                            });
                }
                mIsPlaying = !mIsPlaying;
            }
        }));
    }
}
