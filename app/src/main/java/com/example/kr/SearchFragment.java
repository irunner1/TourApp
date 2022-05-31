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
import com.example.kr.adapter.CardRecsAdapter;
import com.example.kr.fragments.LikedFragment;
import com.example.kr.helpers.Fles;
import com.example.kr.model.CardRecsData;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    RecyclerView cardRecsRecycler;
    CardRecsAdapter cardRecsAdapter;
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
        List<CardRecsData> cardDataList = new ArrayList<>();
        cardDataList.add(new CardRecsData("Нью-Йорк", R.drawable.new_york));
        cardDataList.add(new CardRecsData("Барселона", R.drawable.barsa));
        List<CardRecsData> cardDataList2 = new ArrayList<>();
        cardDataList2.add(new CardRecsData("Рим", R.drawable.tour3));
        cardDataList2.add(new CardRecsData("Париж", R.drawable.paris));

        int SearchID = getResources().getIdentifier("RecViewSearch1", "id", getActivity().getPackageName());
        int Search2ID = getResources().getIdentifier("RecViewSearch2", "id", getActivity().getPackageName());
        setCardRecsRecycler(cardDataList, view, SearchID);
        setCardRecsRecycler(cardDataList2, view, Search2ID);
        return view;
    }

    private void setCardRecsRecycler(List<CardRecsData> cardDataList, View view, int id){
        cardRecsRecycler = view.findViewById(id);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cardRecsRecycler.setLayoutManager(layoutManager);
        cardRecsAdapter = new CardRecsAdapter(this.getContext(), cardDataList);
        cardRecsRecycler.setAdapter(cardRecsAdapter);
    }

    public void onSearchClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", "Поиск");
        getContext().startActivity(i);
    }
}