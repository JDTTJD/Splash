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
import com.tuoren.splash.main.shanghai.If.IShanghaiDetailContract;
import com.tuoren.splash.main.shanghai.presenter.ShanghaiDetailPresenter;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by JDT on 2019/11/14.
 */
@ViewInject(mainlayoutid = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity implements IShanghaiDetailContract.Iview {
    IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);

    public static String mActivityOptionsCompat = "ShanghaiDetailActivity";
    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    public void afterBindView() {
        initAnima();
        initGetNetData();
//        initPostNetData();
    }

    private void initPostNetData() {
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("key","579f1cbcb903065d6c7f89103632f229");
        Request request = new Request.Builder()
                .url("http://apis.juhe.cn/lottery/types")
                .post(builder.build())
                .build();//建造者设计模式
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

    /**
     * 发送网络请求数据
     */
    private void initGetNetData() {
        mPresenter.getNetData();

//        GetXiaoHuaTask task = new GetXiaoHuaTask();
//        task.execute("desc", "1", "2");
//        Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList("desc", "1", "2");
//        if (desc instanceof Response) {
//            Response response = (Response) desc;
//            Log.e("initGetNetData",response.body().toString());
//        }
        /*//1、可以隔离
        OkHttpClient client = new OkHttpClient();
        //2、构建请求 1) url 2) 参数
        HttpUrl.Builder builder = HttpUrl.parse("http://v.juhe.cn/joke/content/list.php").newBuilder();
        builder.addQueryParameter("sort","desc");
        builder.addQueryParameter("page","1");
        builder.addQueryParameter("pagesize","2");
        builder.addQueryParameter("time","" + System.currentTimeMillis()/1000);
        builder.addQueryParameter("key","4fd5a16cadfb5937c361ecf167d9c756");
        //3、构建Request
        Request request = new Request.Builder()
                .url(builder.build())
                .get()
                .build();//建造者设计模式
        //4、构建Call
        Call call = client.newCall(request);
        //5、执行网络请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("initGetData", "onFailure + " + e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.e("initGetData", "onResponse + " + response.body().string());
            }
        });*/
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