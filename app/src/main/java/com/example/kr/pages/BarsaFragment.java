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

public class BarsaFragment extends Fragment {
    RecyclerView cityRecycler;
    CityAdapter cityAdapter;
    private Toolbar toolbar;
    SliderView sliderView;
    int[] images = {R.drawable.barsa, R.drawable.barsa2, R.drawable.barsa3, R.drawable.barsa4, R.drawable.barsa5};

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
        View view = inflater.inflate(R.layout.fragment_barsa, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        sliderView = view.findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.startAutoCycle();
        List<TourData> BarsaDataList = new ArrayList<>();
        BarsaDataList.add(new TourData("Тур около Саграда Де Фамилия","15:00","6 500 р", R.drawable.tourbarsa1));
        BarsaDataList.add(new TourData("Шоу фламенко","15:20","3 500 р", R.drawable.tourbarsa2));
        BarsaDataList.add(new TourData("Тур на автобусе","10:00","2 058 р", R.drawable.tourbarsa3));
        BarsaDataList.add(new TourData("Тур по лучшим видам","9:00","4 047 р", R.drawable.tourbarsa4));
        setTourRecycler(BarsaDataList, view);
        return view;
    }

    private  void setTourRecycler(List<TourData> NYDataList, View view){
        cityRecycler = view.findViewById(R.id.ToursBarsa);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cityRecycler.setLayoutManager(layoutManager);
        cityAdapter = new CityAdapter(this.getContext(), NYDataList);
        cityRecycler.setAdapter(cityAdapter);
    }
}