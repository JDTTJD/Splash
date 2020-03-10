package com.tuoren.splash.main.shenzhen.view;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseActivity;
import com.tuoren.splash.base.ViewInject;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_web_view)
public class WebViewActivity extends BaseActivity {

    @BindView(R.id.web_view)
    WebView web_view;
    @Override
    public void afterBindView() {
        web_view.setWebViewClient(new WebViewClient());
        web_view.loadUrl("http://www.baidu.com");
    }
}
