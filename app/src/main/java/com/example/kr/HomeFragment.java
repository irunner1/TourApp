package com.example.kr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.kr.adapter.RecommendationsAdapter;
import com.example.kr.model.RecData;

import com.example.kr.adapter.CardRecsAdapter;
import com.example.kr.model.CardRecsData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recommendationsRecycler, cardRecsRecycler;
    RecommendationsAdapter recommendationsAdapter;
    CardRecsAdapter cardRecsAdapter;
    Button btnTour, btnHotels, btnRestaurant, btnActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnTour = (Button) view.findViewById(R.id.btnTour);
        btnHotels = (Button) view.findViewById(R.id.btnHotels);
        btnRestaurant = (Button) view.findViewById(R.id.btnRestaurants);
        btnActivity = (Button) view.findViewById(R.id.btnActivity);
        btnTour.setOnClickListener(this::onTourButtonClick);
        btnHotels.setOnClickListener(this::onHotelButtonClick);
        btnRestaurant.setOnClickListener(this::onRestButtonClick);
        btnActivity.setOnClickListener(this::onActivityButtonClick);

        List<RecData> recommendationsDataList = new ArrayList<>();
        recommendationsDataList.add(new RecData("Абхазия","Отправление из Москвы","от 12 699 р", R.drawable.tour1));
        recommendationsDataList.add(new RecData("Турция","Отправление из Москвы","от 19 282 р", R.drawable.tour2));
        recommendationsDataList.add(new RecData("Италия","Отправление из Москвы","от 80 146 р", R.drawable.tour3));
        recommendationsDataList.add(new RecData("Сингапур","Отправление из Москвы","от 50 256 р", R.drawable.singapore));
        setRecommendationsRecycler(recommendationsDataList, view);

        List<CardRecsData> cardDataList = new ArrayList<>();
        cardDataList.add(new CardRecsData("Нью-Йорк", R.drawable.new_york));
        cardDataList.add(new CardRecsData("Барселона", R.drawable.barsa));
        cardDataList.add(new CardRecsData("Рим", R.drawable.tour3));
        cardDataList.add(new CardRecsData("Анталья", R.drawable.antalya));
        setCardRecsRecycler(cardDataList, view);
        return view;
    }

    private  void setRecommendationsRecycler(List<RecData> recentsDataList, View view){
        recommendationsRecycler = view.findViewById(R.id.recommendations);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recommendationsRecycler.setLayoutManager(layoutManager);
        recommendationsAdapter = new RecommendationsAdapter(this.getContext(), recentsDataList);
        recommendationsRecycler.setAdapter(recommendationsAdapter);
    }

    private  void setCardRecsRecycler(List<CardRecsData> cardDataList, View view){
        cardRecsRecycler = view.findViewById(R.id.CardRec);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cardRecsRecycler.setLayoutManager(layoutManager);
        cardRecsAdapter = new CardRecsAdapter(this.getContext(), cardDataList);
        cardRecsRecycler.setAdapter(cardRecsAdapter);
    }

    public void onTourButtonClick(View view) {
        Toast.makeText(getContext(), "This button is working", Toast.LENGTH_LONG).show();
    }
    public void onHotelButtonClick(View view) {
        Toast.makeText(getContext(), "Nice feature", Toast.LENGTH_LONG).show();
    }
    public void onRestButtonClick(View view) {
        Toast.makeText(getContext(), "nah", Toast.LENGTH_LONG).show();
    }
    public void onActivityButtonClick(View view) {
        Toast.makeText(getContext(), "nice", Toast.LENGTH_LONG).show();
    }
}