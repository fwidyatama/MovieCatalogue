package com.example.moviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Item;
import com.example.moviecatalogue.view.DetailTvShow;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.DataHolder> {
    private ArrayList<Item> movieArrayList;
    private Context context;

    public TvAdapter(Context context, ArrayList<Item> movieArrayList){
        this.context=context;
        this.movieArrayList=movieArrayList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, final int position) {

        Glide.with(context)
                .load(movieArrayList.get(position).getPosterPath())
                .into(holder.imgPoster);

        holder.tvTitle.setText(movieArrayList.get(position).getOriginalName());
        holder.tvOverview.setText(movieArrayList.get(position).getOverview());
        holder.tvYear.setText(movieArrayList.get(position).getFirstAirDate());
        holder.tvRating.setText(movieArrayList.get(position).getVoteAverage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(view.getContext(), DetailTvShow.class);
                detailIntent.putExtra(DetailTvShow.EXTRA_TV_SHOW, movieArrayList.get(position));
                view.getContext().startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    class DataHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle;
        TextView tvRating;
        TextView tvYear;
        TextView tvOverview;

        DataHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }
    }
}

