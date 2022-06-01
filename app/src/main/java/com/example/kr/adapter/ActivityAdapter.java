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

public class ActivityAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder>{
    Context context;
    List<TourData> tourDataList;

    public ActivityAdapter(Context context, List<TourData> tourDataList) {
        this.context = context;
        this.tourDataList = tourDataList;
    }

    @NonNull
    @Override
    public TourAdapter.TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity, parent, false);
        return new TourAdapter.TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourAdapter.TourViewHolder holder, int position) {
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

    public static final class TourViewHolder extends RecyclerView.ViewHolder{
        ImageView placeImage;
        TextView placeName, countryName, price;
        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
