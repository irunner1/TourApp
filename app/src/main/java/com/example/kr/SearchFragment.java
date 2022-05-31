package com.example.kr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kr.adapter.SearchAdapter;
import com.example.kr.model.SearchData;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    RecyclerView searchRecycler;
    SearchAdapter searchAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        List<SearchData> searchDataList = new ArrayList<>();
        searchDataList.add(new SearchData("Нью-Йорк", R.drawable.new_york));
        searchDataList.add(new SearchData("Барселона", R.drawable.barsa));

        List<SearchData> searchDataList2 = new ArrayList<>();
        searchDataList2.add(new SearchData("Рим", R.drawable.tour3));
        searchDataList2.add(new SearchData("Анталья", R.drawable.antalya));

        int SearchID = getResources().getIdentifier("RecViewSearch1", "id", getActivity().getPackageName());
        int Search2ID = getResources().getIdentifier("RecViewSearch2", "id", getActivity().getPackageName());
        setSearchRecycler(searchDataList, view, SearchID);
        setSearchRecycler(searchDataList2, view, Search2ID);
        return view;
    }

    private  void setSearchRecycler(List<SearchData> searchDataList, View view, int id){
        searchRecycler = view.findViewById(id);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        searchRecycler.setLayoutManager(layoutManager);
        searchAdapter = new SearchAdapter(this.getContext(), searchDataList);
        searchRecycler.setAdapter(searchAdapter);
    }
}