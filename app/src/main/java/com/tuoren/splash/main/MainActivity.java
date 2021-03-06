package com.tuoren.splash.main;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseActivity;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.tools.MainCostantTool;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.Iview{

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);

    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.rb_main_shanghai)
    LottieAnimationView rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    LottieAnimationView rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    LinearLayout rgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.rb_main_beijing)
    RadioButton rbMainBeijing;
    @BindView(R.id.rb_main_shenzhen)
    RadioButton rbMainShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;

    private boolean isChangeTopOrBottom;



    @Override
    public void afterBindView() {
        initHomeFragment();
        changeAnima(rgMainBottom, rgMainTop);
        initCheckListener();
    }

    private void initCheckListener() {
        rbMainShanghai.playAnimation();
        rbMainShanghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainShanghai.getId() == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                mPresenter.replaceFragment(MainCostantTool.SHANGHAI);
                rbMainShanghai.playAnimation();
                rbMainHangzhou.reverseAnimation();
            }
        });

        rbMainHangzhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbMainHangzhou.getId() == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                mPresenter.replaceFragment(MainCostantTool.HANGZHOU);
                rbMainHangzhou.playAnimation();
                rbMainShanghai.reverseAnimation();
            }
        });

        rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.rb_main_beijing:
                        mPresenter.replaceFragment(MainCostantTool.BEIJING);
                        break;
                    case R.id.rb_main_shenzhen:
                        mPresenter.replaceFragment(MainCostantTool.SHENZHEN);
                        break;
                }
            }
        });
    }


    // 初始化 Fragment
    private void initHomeFragment() {
        mPresenter.initHomeFragment();
    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fac_main_home:
                isChangeTopOrBottom = !isChangeTopOrBottom;
                if (isChangeTopOrBottom) {
                    changeAnima(rgMainTop,rgMainBottom);
                    handleTopPosition();
                } else {
                    changeAnima(rgMainBottom, rgMainTop);
                    handleBottomPosition();
                }
                break;
        }
    }



    //北京 深圳
    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() != MainCostantTool.HANGZHOU) {
            mPresenter.replaceFragment(MainCostantTool.SHANGHAI);
            rbMainShanghai.pauseAnimation();
        } else {
            mPresenter.replaceFragment(MainCostantTool.HANGZHOU);
            rbMainHangzhou.pauseAnimation();
        }
    }


    //上海 杭州  测试branch122
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() != MainCostantTool.SHENZHEN) {
            mPresenter.replaceFragment(MainCostantTool.BEIJING);
            rbMainBeijing.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainCostantTool.SHENZHEN);
            rbMainShenzhen.setChecked(true);
        }
    }

    private void changeAnima(ViewGroup gone, ViewGroup show) {
        //消失动画
        gone.clearAnimation();//清除自身动画
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

        //展示动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content,mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
