package com.tuoren.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tuoren.splash.mvp.ISpalshActivityContract;

import java.io.File;

import butterknife.BindView;

/**
 * Create by JDT on 2019/11/4.
 */
@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISpalshActivityContract.Iview {


    @BindView(R.id.vv_play)
    FullScreenVideoView vvPlay;
    @BindView(R.id.tv_splash_timer)
    TextView tvSplashTimer;
    private ISpalshActivityContract.IPresenter timerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTimerPresenter();
        initListener();
        initVideo();
    }

    private void initTimerPresenter() {
        timerPresenter = new SplashTimerPresent(this);
        timerPresenter.initTimer();
    }

    private void initVideo() {
        vvPlay.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        vvPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

    }

    private void initListener() {

        tvSplashTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

        vvPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

    }


    @Override
    public void setTvTimer(String s) {
        tvSplashTimer.setText(s);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
