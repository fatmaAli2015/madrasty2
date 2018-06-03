package com.example.fatmaali.madrasty2.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fatmaali.madrasty2.Adapter.viewPagerAdapter.SplashAdapter;
import com.example.fatmaali.madrasty2.R;

public class SplashActivity extends AppCompatActivity {
    SplashAdapter splashAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        viewPager = (ViewPager) findViewById(R.id.viewPagerSplash);
        splashAdapter = new SplashAdapter(this);
        viewPager.setAdapter(splashAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

//        View view1 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.bluerec);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view1));
//
//
//        View view2 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.yellowrec);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view2));
//
//
//        View view3 = getLayoutInflater().inflate(R.layout.customtab, null);
//        view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.purrec);
//        tabLayout.addTab(tabLayout.newTab().setCustomView(view3));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    tabLayout.getTabAt(0).setIcon(R.drawable.purrec);

                    tabLayout.getTabAt(1).setIcon(R.drawable.whiterec);
                    tabLayout.getTabAt(2).setIcon(R.drawable.whiterec);
                    tabLayout.getChildAt(0).setMinimumWidth(200);
//                    tabLayout.getTabAt(0).getIcon().setAlpha(255);
//                    tabLayout.getTabAt(1).getIcon().setAlpha(100);
//                    tabLayout.getTabAt(2).getIcon().setAlpha(100);

                }
                if (tab.getPosition() == 1) {
                    tabLayout.getTabAt(0).setIcon(R.drawable.whiterec);
                    tabLayout.getTabAt(1).setIcon(R.drawable.yellowrec);
                    tabLayout.getTabAt(2).setIcon(R.drawable.whiterec);
                }
                if (tab.getPosition() == 2) {
                    tabLayout.getTabAt(0).setIcon(R.drawable.whiterec);
                    tabLayout.getTabAt(1).setIcon(R.drawable.whiterec);
                    tabLayout.getTabAt(2).setIcon(R.drawable.bluerec);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);

    }

    public void btnSkip(View view) {
        Intent LoginIntent = new Intent(this,LoginRegActivity.class);
        startActivity(LoginIntent);
    }
}
