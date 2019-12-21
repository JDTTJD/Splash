package com.tuoren.splash.main.beijing;

import android.view.View;
import android.widget.Button;

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

    @Override
    public void afterBindView() {
        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //去上海
                ShanghaiDetailActivity.start_5_0(getActivity(), tvClick);
            }
        });
    }
}
