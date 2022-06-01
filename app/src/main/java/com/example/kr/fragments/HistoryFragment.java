package com.example.kr.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kr.R;
import com.example.kr.adapter.TourAdapter;
import com.example.kr.model.TourData;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    RecyclerView tourRecycler;
    TourAdapter tourAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_history, container, false);
        List<TourData> tourDataList = new ArrayList<>();
        tourDataList.add(new TourData("Абхазия","5-10 января","12 699 р", R.drawable.tour1));
        tourDataList.add(new TourData("Турция","1-10 мая","19 282 р", R.drawable.tour2));

        setTourRecycler(tourDataList, view);
        return view;
    }

    private  void setTourRecycler(List<TourData> tourDataList, View view){
        tourRecycler = view.findViewById(R.id.RecViewHistory);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        tourRecycler.setLayoutManager(layoutManager);
        tourAdapter = new TourAdapter(this.getContext(), tourDataList);
        tourRecycler.setAdapter(tourAdapter);
    }
}