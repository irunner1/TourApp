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
import com.example.kr.helpers.Fles;
import com.example.kr.model.TourData;

import java.util.ArrayList;
import java.util.List;

public class LikedFragment extends Fragment {
    RecyclerView RecViewLiked;
    TourAdapter likedAdapter;
    public static List<TourData> likedDataList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liked, container, false);

        String tmp = Fles.readFromFile(getContext(), "file"); //Читаются данные из файла
        if (tmp.isEmpty()) { return view; } //Если их нет, выводим пустоту
        likedDataList.clear(); //Очищаем лист
        long count = tmp.chars().filter(ch -> ch == '.').count(); //Считаем колво строк в файле

        for (int j = 0; j < count; j++) {
            String countryName = "", dates = "", prices = "";
            String iteratorName = tmp.substring(0, tmp.indexOf(".") + 1); //Берем подстроку, которая равна первой строке файла
            StringBuffer sb = new StringBuffer(tmp);
            tmp = sb.delete(0, tmp.indexOf(".") + 1).toString(); //удаляем из tmp значение, которое уже используем
            int c1 = iteratorName.indexOf('|'); //находим элемент после названия страны
            int c2 = iteratorName.indexOf('/'); //находим элемент после дат
            for (int i = 0; i < iteratorName.length(); i++) { //парсим данные в переменные
                if (i < c1) {countryName += iteratorName.charAt(i);}
                if (i > c1 && i < c2) {dates += iteratorName.charAt(i);}
                if (i > c2) prices += iteratorName.charAt(i);
            }
            if (countryName.equals("Абхазия")) { likedDataList.add(new TourData(countryName, dates, prices, R.drawable.tour1)); }//можно передавать и R.drawable.pic через int
            if (countryName.equals("Турция")) { likedDataList.add(new TourData(countryName, dates, prices, R.drawable.tour2)); }
            if (countryName.equals("Италия")) { likedDataList.add(new TourData(countryName, dates, prices, R.drawable.tour3)); }
            if (countryName.equals("Сингапур")) { likedDataList.add(new TourData(countryName, dates, prices, R.drawable.singapore)); }
        }
        setHistoryRecycler(likedDataList, view);
        return view;
    }

    private void setHistoryRecycler(List<TourData> likedDataList, View view){
        RecViewLiked = view.findViewById(R.id.RecViewLiked);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        RecViewLiked.setLayoutManager(layoutManager);
        likedAdapter = new TourAdapter(this.getContext(), likedDataList);
        RecViewLiked.setAdapter(likedAdapter);
    }
}