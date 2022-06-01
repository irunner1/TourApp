package com.example.kr.pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kr.R;
import com.example.kr.adapter.ActivityAdapter;
import com.example.kr.model.TourData;

import java.util.ArrayList;
import java.util.List;

public class HotelsFragment extends Fragment {
    private Toolbar toolbar;
    ActivityAdapter activityAdapter;
    RecyclerView activityRecycler;

    private void toolBarSet() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        List<TourData> HotelsDataList = new ArrayList<>();
        HotelsDataList.add(new TourData("Тур по Нью Йорку","15:00","6 500 р", R.drawable.tour1));
        HotelsDataList.add(new TourData("Тур по Манхеттену","15 июля","2 500 р", R.drawable.tour2));
        HotelsDataList.add(new TourData("Италия",""," р", R.drawable.tour3));
        HotelsDataList.add(new TourData("Сингапур",""," р", R.drawable.singapore));
        setActivityRecycler(HotelsDataList, view);
        return view;
    }

    private void setActivityRecycler(List<TourData> HotelsDataList, View view){
        activityRecycler = view.findViewById(R.id.Hotels);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        activityRecycler.setLayoutManager(layoutManager);
        activityAdapter = new ActivityAdapter(this.getContext(), HotelsDataList);
        activityRecycler.setAdapter(activityAdapter);
    }
}