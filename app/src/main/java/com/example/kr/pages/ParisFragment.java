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
import com.example.kr.adapter.CityAdapter;
import com.example.kr.adapter.SliderAdapter;
import com.example.kr.model.TourData;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class ParisFragment extends Fragment {
    RecyclerView cityRecycler;
    CityAdapter cityAdapter;
    private Toolbar toolbar;
    SliderView sliderView;
    int[] images = {R.drawable.paris, R.drawable.paris2, R.drawable.paris3, R.drawable.paris4, R.drawable.paris5, R.drawable.paris6};

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
        View view = inflater.inflate(R.layout.fragment_paris, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        sliderView = view.findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.startAutoCycle();
        List<TourData> ParisDataList = new ArrayList<>();
        ParisDataList.add(new TourData("Экскурсия по катакомбам","15:00","4 365 р", R.drawable.paristour1));
        ParisDataList.add(new TourData("Экскурсия по улицам Парижа","12:00","2 469 р", R.drawable.paristour2));
        ParisDataList.add(new TourData("Экскурсия на Эйфелеву башню","Каждый час","6 106 р", R.drawable.paristour3));
        ParisDataList.add(new TourData("Ночной тур по городу","22:00","1 852 р", R.drawable.paristour4));
        setTourRecycler(ParisDataList, view);
        return view;
    }

    private  void setTourRecycler(List<TourData> ParisDataList, View view){
        cityRecycler = view.findViewById(R.id.ToursParis);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cityRecycler.setLayoutManager(layoutManager);
        cityAdapter = new CityAdapter(this.getContext(), ParisDataList);
        cityRecycler.setAdapter(cityAdapter);
    }
}