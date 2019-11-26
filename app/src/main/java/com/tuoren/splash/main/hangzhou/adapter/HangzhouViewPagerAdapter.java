package com.tuoren.splash.main.hangzhou.adapter;

import com.tuoren.splash.main.hangzhou.view.JiKeFragment;
import com.tuoren.splash.main.hangzhou.view.ZhiHuFragment;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Create by JDT on 2019/11/26.
 */
public class HangzhouViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> titleList = new ArrayList<>();

    public HangzhouViewPagerAdapter(FragmentManager fm) {
        super(fm);
        titleList.add("知乎");
        titleList.add("即刻");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ZhiHuFragment();
            case 1:
                return new JiKeFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
