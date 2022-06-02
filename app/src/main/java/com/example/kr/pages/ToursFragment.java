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

public class ToursFragment extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_tours, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        List<TourData> ToursDataList = new ArrayList<>();
        ToursDataList.add(new TourData("Обзорная автобусная экскурсия по Москве (3 часа)","15:00","6 500 р", R.drawable.msktour1));
        ToursDataList.add(new TourData("Обзорная экскурсия по Москве на автобусе (4 часа)","15 июля","2 500 р", R.drawable.msktour2));
        ToursDataList.add(new TourData("Москва: исторический центр за пару часов",""," р", R.drawable.msktour3));
        ToursDataList.add(new TourData("Пешеходная обзорная экскурсия по Москве",""," р", R.drawable.msktour4));
        setActivityRecycler(ToursDataList, view);
        return view;
    }

    private void setActivityRecycler(List<TourData> ToursDataList, View view){
        activityRecycler = view.findViewById(R.id.Tours);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        activityRecycler.setLayoutManager(layoutManager);
        activityAdapter = new ActivityAdapter(this.getContext(), ToursDataList);
        activityRecycler.setAdapter(activityAdapter);
    }
}