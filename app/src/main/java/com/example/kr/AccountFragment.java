package com.example.kr;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kr.helpers.Fles;
import com.example.kr.pages.EditFragment;
import com.example.kr.Activity.TourActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AccountFragment extends Fragment {
    TextView textView, tv2, tv3, tv4, tv5, txtName;
    String Name = "";
    ImageView imageView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        textView = view.findViewById(R.id.txtEdit);
        tv2 = view.findViewById(R.id.txt);
        tv3 = view.findViewById(R.id.textView10);
        tv4 = view.findViewById(R.id.textView11);
        tv5 = view.findViewById(R.id.textView12);
        txtName = view.findViewById(R.id.txtName);

        textView.setOnClickListener(this::onClick);
        tv2.setOnClickListener(this::onUClick);
        tv3.setOnClickListener(this::onOClick);
        tv4.setOnClickListener(this::onSClick);
        tv5.setOnClickListener(this::onNClick);

        String str = Fles.readFromFile(getContext(), "fle");
        int c1 = str.indexOf('|'); //находим элемент после названия страны
        for (int i = 0; i < str.length(); i++) { //парсим данные в переменные
            if (i < c1) {Name += str.charAt(i);}
        }
        txtName.setText(Name);
        imageView2 = view.findViewById(R.id.imageView2);
        Fles.loadImageFromStorage(getContext(), imageView2);
        return view;
    }

    private void onClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", "Редактировать");
        getContext().startActivity(i);
    }
    private void onUClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", "Уведомления");
        getContext().startActivity(i);
    }
    private void onOClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", "Оплата");
        getContext().startActivity(i);
    }
    private void onNClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", "Настройки");
        getContext().startActivity(i);
    }
    private void onSClick(View view) {
        Intent i = new Intent(getContext(), TourActivity.class);
        i.putExtra("name", "Справка");
        getContext().startActivity(i);
    }
}