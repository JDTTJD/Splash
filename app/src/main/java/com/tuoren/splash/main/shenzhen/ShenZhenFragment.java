package com.tuoren.splash.main.shenzhen;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.tuoren.jetpack.navigation.NavigationActivity;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.shenzhen.view.OpenGlActivity;
import com.tuoren.splash.main.shenzhen.view.WebViewActivity;
import com.tuoren.splash.main.shenzhen.view.WeiXinActivity;

import butterknife.BindView;

/**
 * Create by JDT on 2019/11/8.
 */
@ViewInject(mainlayoutid = R.layout.fragment_shenzhen)
public class ShenZhenFragment extends BaseFragment {

    @BindView(R.id.bt_open_gl)
    Button openGL;
    @BindView(R.id.bt_webview)
    Button webView;
    @BindView(R.id.bt_wx)
    Button weixin;
    @BindView(R.id.jetpack)
    Button jetpack;

    @Override
    public void afterBindView() {
        openGL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), OpenGlActivity.class));
            }
        });

        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WebViewActivity.class));
            }
        });
        weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WeiXinActivity.class));
            }
        });
        jetpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getContext(), LifeCircleActivity.class));
                startActivity(new Intent(getContext(), NavigationActivity.class));
            }
        });
    }

}
