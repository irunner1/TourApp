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
import com.example.kr.model.LikedData;

import java.util.List;

public class LikedAdapter extends RecyclerView.Adapter<LikedAdapter.LikedViewHolder>{
    Context context;
    List<LikedData> likedDataList;

    public LikedAdapter(Context context, List<LikedData> likedDataList) {
        this.context = context;
        this.likedDataList = likedDataList;
    }

    @NonNull
    @Override
    public LikedAdapter.LikedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_trips, parent, false);
        return new LikedAdapter.LikedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikedAdapter.LikedViewHolder holder, int position) {
        holder.countryName.setText(likedDataList.get(position).getCountryName());
        holder.placeName.setText(likedDataList.get(position).getPlaceName());
        holder.price.setText(likedDataList.get(position).getPrice());
        holder.placeImage.setImageResource(likedDataList.get(position).getImageUrl());

        String name = likedDataList.get(position).getPlaceName();
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
        return likedDataList.size();
    }

    public static final class LikedViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;

        public LikedViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
            price = itemView.findViewById(R.id.price);

        }
    }
}
