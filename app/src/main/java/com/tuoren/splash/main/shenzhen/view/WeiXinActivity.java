package com.tuoren.splash.main.shenzhen.view;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseActivity;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.base.tools.FileUtils;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_wei_xin)
public class WeiXinActivity extends BaseActivity {

    @BindView(R.id.bt_js)
    Button bt_js;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @Override
    public void afterBindView() {

        bt_js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解析JS脚本
                //使用 v8 引擎
                V8 v8 = V8.createV8Runtime();
                V8Object v8Object = new V8Object(v8);
                v8.add("wx", v8Object);
                WxTextView wxTextView = new WxTextView();
                v8Object.registerJavaMethod(wxTextView, "textView", "textView", new Class[]{String.class});
                //解析JS文件
                String jsContent = FileUtils.getAssetsContent(WeiXinActivity.this, "js/wx.js");
                //使用V8引擎去 执行js脚本
                v8.executeVoidScript(jsContent);
            }
        });
    }

    public class WxTextView {
        //c++ 调用 Java 方法，都是通过反射的形式
        public void textView(String text) {
            TextView textView = new TextView(WeiXinActivity.this);
            textView.setText(text);
            llContent.addView(textView);
        }
    }
}
