package com.example.moviecatalogue.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.TvShow;
import com.example.moviecatalogue.view.DetailMovies;
import com.example.moviecatalogue.view.DetailTvShow;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvShowHolder> {
    private ArrayList<TvShow> tvShowArrayList;

    public TvAdapter(ArrayList<TvShow> tvShowArrayList) {
        this.tvShowArrayList = tvShowArrayList;
    }

    @NonNull
    @Override
    public TvAdapter.TvShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TvShowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.TvShowHolder holder, final int position) {
        holder.imgPoster.setImageResource(tvShowArrayList.get(position).getPoster());
        holder.tvTitle.setText(tvShowArrayList.get(position).getTitle());
        holder.tvRating.setText(tvShowArrayList.get(position).getRating());
        holder.tvOverview.setText(tvShowArrayList.get(position).getOverview());
        holder.tvYear.setText(tvShowArrayList.get(position).getReleaseDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(view.getContext(), DetailTvShow.class);
                detailIntent.putExtra(DetailTvShow.EXTRA_TVSHOW, tvShowArrayList.get(position));
                view.getContext().startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tvShowArrayList.size();
    }

    public class TvShowHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle;
        TextView tvRating;
        TextView tvYear;
        TextView tvOverview;

        public TvShowHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }
    }
}
