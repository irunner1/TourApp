package com.example.kr;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kr.Activity.TourActivity;
import com.example.kr.adapter.TourAdapter;
import com.example.kr.model.TourData;

import com.example.kr.adapter.CardAdapter;
import com.example.kr.model.CardData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView tourRecycler, cardRecycler;
    TourAdapter tourAdapter;
    CardAdapter cardAdapter;
    Button btnTour, btnHotels, btnRestaurant, btnActivity;
    ScrollView scrollView;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        scrollView = (ScrollView) view.findViewById(R.id.SV);
        tv = (TextView) view.findViewById(R.id.textView7);
        btnTour = (Button) view.findViewById(R.id.btnTour);
        btnHotels = (Button) view.findViewById(R.id.btnHotels);
        btnRestaurant = (Button) view.findViewById(R.id.btnRestaurants);
        btnActivity = (Button) view.findViewById(R.id.btnActivity);
        btnTour.setOnClickListener(this::onTourButtonClick);
        btnHotels.setOnClickListener(this::onHotelButtonClick);
        btnRestaurant.setOnClickListener(this::onRestButtonClick);
        btnActivity.setOnClickListener(this::onActivityButtonClick);

        List<TourData> TourDataList = new ArrayList<>();
        TourDataList.add(new TourData("Абхазия","Отправление из Москвы","от 12 699 р", R.drawable.tour1));
        TourDataList.add(new TourData("Турция","Отправление из Москвы","от 19 282 р", R.drawable.tour2));
        TourDataList.add(new TourData("Италия","Отправление из Москвы","от 80 146 р", R.drawable.tour3));
        TourDataList.add(new TourData("Сингапур","Отправление из Москвы","от 50 256 р", R.drawable.singapore));
        setTourRecycler(TourDataList, view);

        List<CardData> cardDataList = new ArrayList<>();
        cardDataList.add(new CardData("Нью-Йорк", R.drawable.new_york));
        cardDataList.add(new CardData("Барселона", R.drawable.barsa));
        cardDataList.add(new CardData("Рим", R.drawable.tour3));
        cardDataList.add(new CardData("Анталья", R.drawable.antalya));
        setCardRecycler(cardDataList, view);
        return view;
    }

    private  void setTourRecycler(List<TourData> tourDataList, View view){
        tourRecycler = view.findViewById(R.id.recommendations);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        tourRecycler.setLayoutManager(layoutManager);
        tourAdapter = new TourAdapter(this.getContext(), tourDataList);
        tourRecycler.setAdapter(tourAdapter);
    }

    private  void setCardRecycler(List<CardData> cardList, View view){
        cardRecycler = view.findViewById(R.id.CardRec);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        cardRecycler.setLayoutManager(layoutManager);
        cardAdapter = new CardAdapter(this.getContext(), cardList);
        cardRecycler.setAdapter(cardAdapter);
    }

    public void onTourButtonClick(View view) {
//        Intent i = new Intent(getContext(), TourActivity.class);
//        i.putExtra("name", btnTour.getText().toString());
//        getContext().startActivity(i);
        scrollView.scrollTo(tv.getScrollX(), tv.getScrollY());
    }
    public void onHotelButtonClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", btnHotels.getText().toString());
        getContext().startActivity(i);
    }
    public void onRestButtonClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", btnRestaurant.getText().toString());
        getContext().startActivity(i);
    }
    public void onActivityButtonClick(View view) {
        Toast.makeText(getContext(), "nice", Toast.LENGTH_LONG).show();
    }
}