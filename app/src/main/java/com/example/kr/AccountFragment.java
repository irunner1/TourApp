package com.example.kr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AccountFragment extends Fragment {
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        textView = view.findViewById(R.id.txtEdit);
        textView.setOnClickListener(this::onClick);
        return view;
    }

    private void onClick(View view) {
//        добавить страницу
    }
}