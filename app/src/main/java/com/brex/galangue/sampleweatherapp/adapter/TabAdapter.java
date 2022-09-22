package com.brex.galangue.sampleweatherapp.adapter;

import android.content.Context;

import com.brex.galangue.sampleweatherapp.controller.fragments.FirstPageFragment;
import com.brex.galangue.sampleweatherapp.controller.fragments.SecondPageFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public TabAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FirstPageFragment firstPageFragment = new FirstPageFragment();
                return firstPageFragment;
            case 1:
                SecondPageFragment secondPageFragment = new SecondPageFragment();
                return secondPageFragment;

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
