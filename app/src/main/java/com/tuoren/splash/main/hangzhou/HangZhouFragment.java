package com.tuoren.splash.main.hangzhou;

import com.google.android.material.tabs.TabLayout;
import com.tuoren.splash.R;
import com.tuoren.splash.base.BaseFragment;
import com.tuoren.splash.base.ViewInject;
import com.tuoren.splash.main.shenzhen.ShenZhenFragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Create by JDT on 2019/11/8.
 */
@ViewInject(mainlayoutid = R.layout.fragment_hangzhou)
public class HangZhouFragment extends BaseFragment {

    @BindView(R.id.tl_tablayout)
    TabLayout tlTablayout;
    @BindView(R.id.vp_viewpager)
    ViewPager vpViewpager;

    @Override
    public void afterBindView() {
        tlTablayout.setupWithViewPager(vpViewpager);
        vpViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return new ShenZhenFragment();
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return "深圳";
            }
        });
    }
}
