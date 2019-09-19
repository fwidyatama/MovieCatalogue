package com.example.moviecatalogue.adapter;

import android.content.Context;
import android.media.Rating;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    Context context;
    ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context) {
        this.context = context;
        movieArrayList = new ArrayList<>();
    }

    public void setMovieArrayList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @Override
    public int getCount() {
        return movieArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);

        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }


    private class ViewHolder {
        ImageView imgPoster;
        TextView tvTitle;
        TextView tvYear;
        TextView tvRating;
        TextView tvOverview;

        ViewHolder(View view) {
            imgPoster = view.findViewById(R.id.imgPoster);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvYear = view.findViewById(R.id.tvYear);
            tvRating = view.findViewById(R.id.tvRating);
            tvOverview = view.findViewById(R.id.tvOverview);
        }

        void bind(Movie movie) {
            imgPoster.setImageResource(movie.getPoster());
            tvTitle.setText(movie.getTitle());
            tvYear.setText(movie.getReleaseDate());
            tvRating.setText(movie.getRating());
            if (movie.getOverview().length() > 100) {
                tvOverview.setText(movie.getOverview().substring(0, 100) + "...");
            }
        }


    }
}

