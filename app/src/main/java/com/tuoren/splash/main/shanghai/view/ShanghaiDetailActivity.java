package com.tuoren.splash.main.shanghai.view;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseActivity;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.beijing.MainProcessService;
import com.tuoren.splash.main.shanghai.If.IShanghaiDetailContract;
import com.tuoren.splash.main.shanghai.dto.ShanghaiDetailBean;
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
import okhttp3.HttpUrl;
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
    @BindView(R.id.tv_crash)
    TextView mTvCrash;

    private Messenger messenger;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle data = msg.getData();
            Log.e(mActivityOptionsCompat, "processDec = " + data.getString("process"));
        }
    };
    private Messenger messengerClient = new Messenger(handler);

//    private GetProcessReceiver getProcessReceiver;
    //    @BindView(R.id.GLSurfaceView)
//    GLSurfaceView glSurfaceView;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            Message message = new Message();
            message.what = MainProcessService.SHANGHAI_DETAIL;
            message.replyTo = messengerClient;
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    public void afterBindView() {
        initAnima();
//        initReceiver();
//        initProcessData();
        initGetNetData();
//        initPostNetData();
//        initProviderData();
        initProcessService();
    }

    private void initProcessService() {
        Intent intent = new Intent(this, MainProcessService.class);
        bindService(intent, mConnection, Service.BIND_AUTO_CREATE);
    }

//    private void initProviderData() {
//        Uri insert = getContentResolver().insert(Uri.parse("content://com.tuoren.splash.process.data"), new ContentValues());
//        Log.e(mActivityOptionsCompat, "processDec = " + insert.toString());
//    }

//    private void initReceiver() {
//        getProcessReceiver = new GetProcessReceiver();
//        registerReceiver(getProcessReceiver, new IntentFilter("beijing_post_process_data"));
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(getProcessReceiver);
    }

//    private void initProcessData() {
//        Intent intent = new Intent("shanghai_get_process_data");
//        sendBroadcast(intent);
//    }

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
//        ivShanghaiDetail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPresenter.getNetData();
//            }
//        });

//        GetXiaoHuaTask task = new GetXiaoHuaTask();
//        task.execute("desc", "1", "2");
//        Object desc = new ShangHaiDetailHttpTask().getXiaoHuaList("desc", "1", "2");
//        if (desc instanceof Response) {
//            Response response = (Response) desc;
//            Log.e("initGetNetData",response.body().toString());
//        }
        //1、可以隔离
        OkHttpClient client = new OkHttpClient();
        //2、构建请求 1) url 2) 参数
        HttpUrl.Builder builder = HttpUrl.parse("http://www.baidu.com").newBuilder();
//        builder.addQueryParameter("sort","desc");
//        builder.addQueryParameter("page","1");
//        builder.addQueryParameter("pagesize","2");
//        builder.addQueryParameter("time","" + System.currentTimeMillis()/1000);
//        builder.addQueryParameter("key","4fd5a16cadfb5937c361ecf167d9c756");
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

    @Override
    public void showData(ShanghaiDetailBean data) {

    }

//    private class GetProcessReceiver extends BroadcastReceiver {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String processDec = intent.getStringExtra("processDec");
//            Log.e(mActivityOptionsCompat, "processDec = " + processDec);
//        }
//    }
}
