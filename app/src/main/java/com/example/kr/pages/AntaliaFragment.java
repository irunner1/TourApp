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

public class AntaliaFragment extends Fragment {
    RecyclerView cityRecycler;
    CityAdapter cityAdapter;
    private Toolbar toolbar;
    SliderView sliderView;
    int[] images = {R.drawable.antalya, R.drawable.antalia, R.drawable.antalia2, R.drawable.antalia3, R.drawable.antalia4};

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
        View view = inflater.inflate(R.layout.fragment_antalia, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        sliderView = view.findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.startAutoCycle();
        List<TourData> AntaliaDataList = new ArrayList<>();
        AntaliaDataList.add(new TourData("Тур по городу","15:00","3 700 р", R.drawable.antalia));
        AntaliaDataList.add(new TourData("Экстримальный отдых","10:15","4 700 р", R.drawable.antalia));
        AntaliaDataList.add(new TourData("Тур по достопримечательностям","8:00","3 087 р", R.drawable.antalia));
        AntaliaDataList.add(new TourData("Тур по каньону","8:30","3 700 р", R.drawable.antalia));
        setTourRecycler(AntaliaDataList, view);
        return view;
    }

    private  void setTourRecycler(List<TourData> AntaliaDataList, View view){
        cityRecycler = view.findViewById(R.id.ToursAntalia);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cityRecycler.setLayoutManager(layoutManager);
        cityAdapter = new CityAdapter(this.getContext(), AntaliaDataList);
        cityRecycler.setAdapter(cityAdapter);
    }
}