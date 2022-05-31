package com.example.kr.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.kr.fragments.HistoryFragment;
import com.example.kr.fragments.LikedFragment;
import com.example.kr.fragments.NextTripFragment;

public class VPAdapter extends FragmentStateAdapter {

    public VPAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new LikedFragment();
            case 2:
                return new HistoryFragment();
        }
        return new NextTripFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
