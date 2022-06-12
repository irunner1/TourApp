package com.example.kr.pages;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.kr.R;
import com.example.kr.fragments.LikedFragment;
import com.example.kr.helpers.Fles;

public class TurkeyFragment extends Fragment {
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
        View view = inflater.inflate(R.layout.fragment_turkey, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        btn = (ImageButton)view.findViewById(R.id.imageButtonTurkey);
        btn.setOnClickListener(this::onButtonClick);
        String tmp = Fles.readFromFile(getContext(), "file"); //Проверка наличия страны в файле
        if (tmp.contains("Турция")) {
            active_btn = true;
            btn.setImageResource(R.drawable.like_filled);
        }
        return view;
    }

    public void onButtonClick(View view) {
        if (active_btn) {
            active_btn = false;
            btn.setImageResource(R.drawable.like);
            if (!LikedFragment.likedDataList.isEmpty()) {
                LikedFragment.likedDataList.removeIf(o -> o.equals("Турция"));
            }
            Fles.deleteFromFile(getContext(), "Турция|10-20 июля/19 282 р.", "file");
            return;
        }
        active_btn = true;
        Fles.writeToFile("Турция", "10-20 июля", "19 282 р.", getContext(), "file");
        btn.setImageResource(R.drawable.like_filled);
    }
}