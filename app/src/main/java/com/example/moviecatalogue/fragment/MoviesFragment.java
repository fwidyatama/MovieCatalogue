package com.example.moviecatalogue.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.adapter.MovieAdapter;
import com.example.moviecatalogue.model.Movie;

import java.util.ArrayList;


public class MoviesFragment extends Fragment {
    private RecyclerView recyclerView;
    private String[] movieTitle;
    private String[] movieOverview;
    private String[] releaseDate;
    private TypedArray moviePoster;
    private String[] movieBackground;
    private String[] movieRating;
    private String[] movieDuration;
    private String[] movieBudget;
    private ArrayList<Movie> movieArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = view.findViewById(R.id.rv_movies);
        recyclerView.setHasFixedSize(true);

        getAllResource();
        insertData();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieAdapter movieAdapter = new MovieAdapter(movieArrayList);
        recyclerView.setAdapter(movieAdapter);
        return view;
    }

    private void insertData() {
        for (int i = 0; i < movieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(movieTitle[i]);
            movie.setOverview(movieOverview[i]);
            movie.setReleaseDate(releaseDate[i]);
            movie.setPoster(moviePoster.getResourceId(i, -1));
            movie.setDuration(movieDuration[i]);
            movie.setRating(movieRating[i]);
            movie.setBudget(movieBudget[i]);
            movie.setBackground(movieBackground[i]);
            movieArrayList.add(movie);
        }

    }

    private void getAllResource() {
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieOverview = getResources().getStringArray(R.array.movie_overview);
        releaseDate = getResources().getStringArray(R.array.movie_year);
        moviePoster = getResources().obtainTypedArray(R.array.movie_poster);
        movieDuration = getResources().getStringArray(R.array.movie_duration);
        movieRating = getResources().getStringArray(R.array.movie_rating);
        movieBudget = getResources().getStringArray(R.array.movie_budget);
        movieBackground = getResources().getStringArray(R.array.link_background_movies);
    }

}
