package com.example.kr.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kr.Activity.TourActivity;
import com.example.kr.R;

public class FindFragment extends Fragment {
    private Toolbar toolbar;
    SearchView searchView;
    ListView listView;
    String[] name = {"Нью-Йорк", "Барселона", "Рим", "Анталья", "Турция", "Италия", "Абхазия", "Сингапур", "Париж", "Туры", "Отели", "Рестораны"};
    Context context;
    ArrayAdapter<String> arrayAdapter;

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
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolBarSet();
        searchView = view.findViewById(R.id.SearchView);
        listView = (ListView) view.findViewById(R.id.Searc);
        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listView.getItemAtPosition(position);
                Intent i = new Intent(context, TourActivity.class);
                i.putExtra("name", item);
                context.startActivity(i);
            }
        });
        return view;
    }
}