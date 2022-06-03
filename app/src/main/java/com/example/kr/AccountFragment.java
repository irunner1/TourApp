package com.example.kr;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kr.Activity.TourActivity;

public class AccountFragment extends Fragment {
    TextView textView, tv2, tv3, tv4, tv5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        textView = view.findViewById(R.id.txtEdit);
        tv2 = view.findViewById(R.id.txt);
        tv3 = view.findViewById(R.id.textView10);
        tv4 = view.findViewById(R.id.textView11);
        tv5 = view.findViewById(R.id.textView12);
        textView.setOnClickListener(this::onClick);
        tv2.setOnClickListener(this::onUClick);
        tv3.setOnClickListener(this::onOClick);
        tv4.setOnClickListener(this::onSClick);
        tv5.setOnClickListener(this::onNClick);
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