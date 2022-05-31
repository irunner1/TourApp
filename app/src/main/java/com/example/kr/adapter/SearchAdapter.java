package com.example.kr.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kr.Activity.TourActivity;
import com.example.kr.R;
import com.example.kr.model.SearchData;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder>{
    Context context;
    List<SearchData> searchDataList;

    public SearchAdapter(Context context, List<SearchData> searchDataList) {
        this.context = context;
        this.searchDataList = searchDataList;
    }

    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardrecs, parent, false);
        return new SearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        holder.placeName.setText(searchDataList.get(position).getPlaceName());
        holder.placeImage.setImageResource(searchDataList.get(position).getImageUrl());

        String name = searchDataList.get(position).getPlaceName();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, TourActivity.class);
                i.putExtra("name", name);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchDataList.size();
    }

    public static final class SearchViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
        }
    }
}