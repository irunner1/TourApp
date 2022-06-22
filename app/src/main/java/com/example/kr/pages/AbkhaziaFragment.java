package com.example.kr.pages;

import android.os.Bundle;
import com.example.kr.fragments.LikedFragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.kr.R;
import com.example.kr.helpers.Fles;

public class AbkhaziaFragment extends Fragment {
    private Toolbar toolbar;
    ImageButton btn;
    boolean active_btn = false;

    private void toolBarSet() {
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_abkhazia, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        btn = (ImageButton)view.findViewById(R.id.imageButton);
        btn.setOnClickListener(this::onMyButtonClick);

        String tmp = Fles.readFromFile(getContext(), "file"); //Проверка наличия страны в файле
        if (tmp.contains("Абхазия")) {
            active_btn = true;
            btn.setImageResource(R.drawable.like_filled);
        }
        return view;
    }

    public void onMyButtonClick(View view) {
        if (active_btn) {
            active_btn = false;
            btn.setImageResource(R.drawable.like);
            if (!LikedFragment.likedDataList.isEmpty()) {
                LikedFragment.likedDataList.removeIf(o -> o.equals("Абхазия"));
            }
            Fles.deleteFromFile(getContext(), "Абхазия|55 июля/13 699р.", "file");
            return;
        }
        active_btn = true;
        Fles.writeFile("Абхазия|", "55 июля/", "13 699р.", getContext(), "file", 1);
        btn.setImageResource(R.drawable.like_filled);
    }
}