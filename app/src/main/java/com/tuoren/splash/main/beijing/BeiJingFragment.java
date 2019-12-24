package com.tuoren.splash.main.beijing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.shanghai.view.ShanghaiDetailActivity;

import butterknife.BindView;

/**
 * Create by JDT on 2019/11/8.
 */
@ViewInject(mainlayoutid = R.layout.fragment_beijing)
public class BeiJingFragment extends BaseFragment {
    @BindView(R.id.bt_play)
    Button tvClick;
//    private ProcessDataReceiver processDataReceiver;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    public void afterBindView() {
        mContext.startService(new Intent(mContext, MainProcessService.class));
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //去上海
                ProcessDataTest.getInstance().setProcessDec("你好，我来自北京1");
                ShanghaiDetailActivity.start_5_0(getActivity(), tvClick);
            }
        });
        //注册广播，来接收
//        processDataReceiver = new ProcessDataReceiver();
//        getActivity().registerReceiver(processDataReceiver, new IntentFilter("shanghai_get_process_data"));
        //测试网络变化广播
        networkChangeReceiver = new NetworkChangeReceiver();
        getActivity().registerReceiver(networkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext.stopService(new Intent(mContext, MainProcessService.class));
//        getActivity().unregisterReceiver(processDataReceiver);
    }

//    private class ProcessDataReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            String processDec = ProcessDataTest.getInstance().getProcessDec();
//            Intent postIntent = new Intent("beijing_post_process_data");
//            postIntent.putExtra("processDec", processDec);
//            getActivity().sendBroadcast(postIntent);
//        }
//    }

    private class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
