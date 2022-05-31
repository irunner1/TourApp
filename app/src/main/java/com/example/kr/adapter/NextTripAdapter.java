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
import com.example.kr.model.NextTripsData;

import java.util.List;

public class NextTripAdapter extends RecyclerView.Adapter<NextTripAdapter.NextTripsViewHolder> {

    Context context;
    List<NextTripsData> nextTripsDataList;

    public NextTripAdapter(Context context, List<NextTripsData> nextTripsDataList) {
        this.context = context;
        this.nextTripsDataList = nextTripsDataList;
    }

    @NonNull
    @Override
    public NextTripAdapter.NextTripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.next_trips, parent, false);
        return new NextTripAdapter.NextTripsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NextTripAdapter.NextTripsViewHolder holder, int position) {
        holder.countryName.setText(nextTripsDataList.get(position).getCountryName());
        holder.placeName.setText(nextTripsDataList.get(position).getPlaceName());
        holder.placeImage.setImageResource(nextTripsDataList.get(position).getImageUrl());


        String name = nextTripsDataList.get(position).getPlaceName();
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
        return nextTripsDataList.size();
    }

    public static final class NextTripsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName;

        public NextTripsViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);
        }
    }
}