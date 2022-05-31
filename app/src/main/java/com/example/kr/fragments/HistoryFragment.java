package com.example.kr.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kr.R;
import com.example.kr.adapter.HistoryAdapter;
import com.example.kr.model.HistoryData;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    RecyclerView RecViewHistory;
    HistoryAdapter historyAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_history, container, false);
        List<HistoryData> historyDataList = new ArrayList<>();
        historyDataList.add(new HistoryData("Абхазия","15-20 июля","13 699 р", R.drawable.tour1));
        historyDataList.add(new HistoryData("Абхазия","15-20 июля","13 699 р", R.drawable.tour1));

        setHistoryRecycler(historyDataList, view);
        return view;
    }

    private void setHistoryRecycler(List<HistoryData> historyDataList, View view){
        RecViewHistory = view.findViewById(R.id.RecViewHistory);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        RecViewHistory.setLayoutManager(layoutManager);
        historyAdapter = new HistoryAdapter(this.getContext(), historyDataList);
        RecViewHistory.setAdapter(historyAdapter);
    }
}