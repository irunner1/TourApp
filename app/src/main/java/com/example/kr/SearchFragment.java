package com.example.kr;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.kr.Activity.TourActivity;
import com.example.kr.adapter.CardAdapter;
import com.example.kr.model.CardData;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    RecyclerView cardRecycler;
    CardAdapter cardAdapter;
    EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        editText = (EditText) view.findViewById(R.id.editText);
        editText.setOnClickListener(this::onSearchClick);
        List<CardData> cardDataList = new ArrayList<>();
        cardDataList.add(new CardData("Нью-Йорк", R.drawable.new_york));
        cardDataList.add(new CardData("Барселона", R.drawable.barsa));
        List<CardData> cardDataList2 = new ArrayList<>();
        cardDataList2.add(new CardData("Рим", R.drawable.tour3));
        cardDataList2.add(new CardData("Париж", R.drawable.paris));

        int SearchID = getResources().getIdentifier("RecViewSearch1", "id", getActivity().getPackageName());
        int Search2ID = getResources().getIdentifier("RecViewSearch2", "id", getActivity().getPackageName());
        setCardRecycler(cardDataList, view, SearchID);
        setCardRecycler(cardDataList2, view, Search2ID);
        return view;
    }

    private void setCardRecycler(List<CardData> cardDataList, View view, int id){
        cardRecycler = view.findViewById(id);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cardRecycler.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(this.getContext(), cardDataList);
        cardRecycler.setAdapter(cardAdapter);
    }

    public void onSearchClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", "Поиск");
        getContext().startActivity(i);
    }
}