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

public class RomaFragment extends Fragment {
    RecyclerView cityRecycler;
    CityAdapter cityAdapter;
    private Toolbar toolbar;
    SliderView sliderView;
    int[] images = {R.drawable.rome, R.drawable.rome2, R.drawable.rome3, R.drawable.rome5, R.drawable.rome6, R.drawable.tour3};

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
        View view = inflater.inflate(R.layout.fragment_roma, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        sliderView = view.findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.startAutoCycle();
        List<TourData> RomaDataList = new ArrayList<>();
        RomaDataList.add(new TourData("Тур по Нью Йорку","15:00","6 500 р", R.drawable.tour1));
        RomaDataList.add(new TourData("Тур по Манхеттену","15 июля","2 500 р", R.drawable.tour2));
        RomaDataList.add(new TourData("Италия",""," р", R.drawable.tour3));
        RomaDataList.add(new TourData("Сингапур",""," р", R.drawable.singapore));
        setTourRecycler(RomaDataList, view);
        return view;
    }

    private  void setTourRecycler(List<TourData> RomaDataList, View view){
        cityRecycler = view.findViewById(R.id.ToursRoma);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cityRecycler.setLayoutManager(layoutManager);
        cityAdapter = new CityAdapter(this.getContext(), RomaDataList);
        cityRecycler.setAdapter(cityAdapter);
    }
}