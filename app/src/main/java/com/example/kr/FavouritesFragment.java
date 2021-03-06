package com.example.kr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kr.adapter.VPAdapter;
import com.google.android.material.tabs.TabLayout;

public class FavouritesFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    VPAdapter vpAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);
        setViewPager2(view);
        return view;
    }

    private  void setViewPager2(View view){
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager);
        FragmentManager fragmentManager = getParentFragmentManager();
        vpAdapter = new VPAdapter(fragmentManager, getLifecycle());
        viewPager2.setAdapter(vpAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                System.out.println("history");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}