package com.tuoren.splash.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseActivity;
import com.tuoren.splash.base.ViewInject;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by JDT on 2019/11/14.
 */
@ViewInject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity {
    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";
    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        initAnima();
        initGetData();
    }

    /**
     * 发送网络请求数据
     */
    private void initGetData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").get().build();//建造者设计模式
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("initGetData", "onFailure + " + e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("initGetData", "onResponse + " + response.body().string());
            }
        });
    }

    private void initAnima() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //下面这行代码可以注释掉，因为这个起到关联作用的TransitionName在xml文件中添加了
            //ViewCompat.setTransitionName(ivShanghaiDetail,mActivityOptionsCompat);
            //开启转场动画
            startPostponedEnterTransition();
        }
    }

    /**
     * 用于Android5.0系统界面转场动画：共享元素动画
     */
    public static void start_5_0(Activity activity,View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent(activity,ShanghaiDetailActivity.class);
            Pair pair = new Pair(view,mActivityOptionsCompat);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }
}
