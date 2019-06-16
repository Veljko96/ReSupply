package com.example.veljkodjordjevic.resupply.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.veljkodjordjevic.resupply.R;
import com.example.veljkodjordjevic.resupply.model.Charity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharityAdapter extends RecyclerView.Adapter<CharityAdapter.ViewHolder> {

    private Context applicationContext;
    private List<Charity> charities;

    public CharityAdapter(Context applicationContext, List<Charity> charities) {

        this.applicationContext = applicationContext;
        this.charities = charities;

    }



    @NonNull
    @Override
    public CharityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_charity, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        int count = charities.get(i).getRating_count();
        int average = charities.get(i).getAverage_rating();
        String cound_and_average = Integer.toString(count) + " | " + Integer.toString(average);
        viewHolder.nameTextView.setText(charities.get(i).getName());
        viewHolder.ratingsTextView.setText(cound_and_average);

        Picasso.get()
                .load(charities.get(i).getPhoto().getUrl())
                .placeholder(R.drawable.white)
                .into(viewHolder.photo);

    }

    @Override
    public int getItemCount() {
        return charities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView ratingsTextView;
        private ImageView photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.textView1);
            ratingsTextView = (TextView) itemView.findViewById(R.id.textView2);
            photo = (ImageView) itemView.findViewById(R.id.charity_photo);
        }
    }
}
