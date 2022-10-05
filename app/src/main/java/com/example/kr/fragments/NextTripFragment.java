package com.example.kr.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kr.R;
import com.example.kr.adapter.NextTripAdapter;
import com.example.kr.adapter.TourAdapter;
import com.example.kr.model.NextTripsData;
import com.example.kr.model.TourData;

import java.util.ArrayList;
import java.util.List;

public class NextTripFragment extends Fragment {
    RecyclerView RecViewNextTrips;
    NextTripAdapter nextTripAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recent_tours, container, false);
        List<NextTripsData> NextTripDataList = new ArrayList<>();
        NextTripDataList.add(new NextTripsData("Абхазия","15-20 июля",R.drawable.tour1));
        setNextTripRecycler(NextTripDataList, view);
        return view;
    }
    private void setNextTripRecycler(List<NextTripsData> NextTripDataList, View view){
        RecViewNextTrips = view.findViewById(R.id.RecViewNextTrips);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        RecViewNextTrips.setLayoutManager(layoutManager);
        nextTripAdapter = new NextTripAdapter(this.getContext(), NextTripDataList);
        RecViewNextTrips.setAdapter(nextTripAdapter);
    }
}