package com.example.kr.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kr.Activity.TourActivity;
import com.example.kr.R;
import com.example.kr.model.TourData;
import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.RecommendationsViewHolder> {
    Context context;
    List<TourData> tourDataList;

    public TourAdapter(Context context, List<TourData> recommendationsDataList) {
        this.context = context;
        this.tourDataList = recommendationsDataList;
    }

    @NonNull
    @Override
    public RecommendationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommendations, parent, false);
        return new RecommendationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendationsViewHolder holder, int position) {
        holder.countryName.setText(tourDataList.get(position).getCountryName());
        holder.placeName.setText(tourDataList.get(position).getPlaceName());
        holder.price.setText(tourDataList.get(position).getPrice());
        holder.placeImage.setImageResource(tourDataList.get(position).getImageUrl());
        String name = tourDataList.get(position).getPlaceName();
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
        return tourDataList.size();
    }

    public static final class RecommendationsViewHolder extends RecyclerView.ViewHolder{
        ImageView placeImage;
        TextView placeName, countryName, price;
        public RecommendationsViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);
        }
    }
}