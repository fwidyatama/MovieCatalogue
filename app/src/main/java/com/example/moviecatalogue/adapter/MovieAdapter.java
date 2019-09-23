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
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.view.DetailMovies;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.DataHolder> {
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, final int position) {
        holder.imgPoster.setImageResource(movieArrayList.get(position).getPoster());
        holder.tvTitle.setText(movieArrayList.get(position).getTitle());
        holder.tvRating.setText(movieArrayList.get(position).getRating());
        holder.tvOverview.setText(movieArrayList.get(position).getOverview());
        holder.tvYear.setText(movieArrayList.get(position).getReleaseDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(view.getContext(), DetailMovies.class);
                detailIntent.putExtra(DetailMovies.EXTRA_MOVIE, movieArrayList.get(position));
                view.getContext().startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    public class DataHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle;
        TextView tvRating;
        TextView tvYear;
        TextView tvOverview;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }
    }
}

