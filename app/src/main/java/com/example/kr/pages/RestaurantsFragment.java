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
import com.example.kr.adapter.CityAdapter;
import com.example.kr.model.TourData;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsFragment extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        List<TourData> RestaurantsDataList = new ArrayList<>();
        RestaurantsDataList.add(new TourData("Сабор де ла Вида Ресторан","ул. 1905 года, 10/1","РРРР", R.drawable.rest1));
        RestaurantsDataList.add(new TourData("Джумбус","ул. Добровольческая 12","РРР", R.drawable.rest2));
        RestaurantsDataList.add(new TourData("[KU:] рамен изакая бар","Большая Грузинская, 69","РР", R.drawable.rest3));
        RestaurantsDataList.add(new TourData("Любовь Пирогова","ул. Мытная, 74 Даниловский рынок","РР", R.drawable.rest4));
        setActivityRecycler(RestaurantsDataList, view);
        return view;
    }

    private void setActivityRecycler(List<TourData> RestaurantsDataList, View view){
        activityRecycler = view.findViewById(R.id.Restaurants);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        activityRecycler.setLayoutManager(layoutManager);
        activityAdapter = new ActivityAdapter(this.getContext(), RestaurantsDataList);
        activityRecycler.setAdapter(activityAdapter);
    }
}