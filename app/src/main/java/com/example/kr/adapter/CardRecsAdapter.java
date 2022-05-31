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
import com.example.kr.model.CardRecsData;

import java.util.List;

public class CardRecsAdapter extends RecyclerView.Adapter<CardRecsAdapter.CardRecsViewHolder> {
    Context context;
    List<CardRecsData> cardDataList;

    public CardRecsAdapter(Context context, List<CardRecsData> cardDataList) {
        this.context = context;
        this.cardDataList = cardDataList;
    }

    @NonNull
    @Override
    public CardRecsAdapter.CardRecsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardrecs, parent, false);
        return new CardRecsAdapter.CardRecsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardRecsAdapter.CardRecsViewHolder holder, int position) {
        holder.placeName.setText(cardDataList.get(position).getPlaceName());
        holder.placeImage.setImageResource(cardDataList.get(position).getImageUrl());

        String name = cardDataList.get(position).getPlaceName();
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
        return cardDataList.size();
    }

    public static final class CardRecsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName;

        public CardRecsViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
        }
    }
}
