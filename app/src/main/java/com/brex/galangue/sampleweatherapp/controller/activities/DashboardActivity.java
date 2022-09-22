package com.brex.galangue.sampleweatherapp.controller.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.brex.galangue.sampleweatherapp.R;
import com.brex.galangue.sampleweatherapp.adapter.TabAdapter;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    TabLayout tab_layout;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initializeIds();
    }

    private void initializeIds(){
        tab_layout =  findViewById(R.id.tab_layout);
        pager =  findViewById(R.id.pager);

        tab_layout.addTab(tab_layout.newTab().setText("First page"));
        tab_layout.addTab(tab_layout.newTab().setText("Second page"));
        tab_layout.setTabGravity(TabLayout.GRAVITY_FILL);

        final TabAdapter adapter = new TabAdapter(DashboardActivity.this, getSupportFragmentManager(), tab_layout.getTabCount());
        pager.setAdapter(adapter);
//        tab_layout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }




}