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
import com.example.moviecatalogue.adapter.TvAdapter;
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.TvShow;

import java.util.ArrayList;

public class TvShowFragment extends Fragment {
    private RecyclerView recyclerView;
    private String[] tvShowTitle;
    private String[] tvShowOverview;
    private String[] tvShowreleaseDate;
    private TypedArray tvShowPoster;
    private String[] tvShowBackground;
    private String[] tvShowRating;
    private String[] tvShowDuration;
    private String[] tvShowGenre;
    private String[] tvShowEpisode;

    private ArrayList<TvShow> tvShowArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);
        recyclerView = view.findViewById(R.id.rv_tvShow);
        recyclerView.setHasFixedSize(true);

        getAllResource();
        insertData();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvAdapter movieAdapter = new TvAdapter(tvShowArrayList);
        recyclerView.setAdapter(movieAdapter);

        recyclerView = view.findViewById(R.id.rv_tvShow);
        Log.d("BACA", String.valueOf(recyclerView));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvAdapter tvAdapter = new TvAdapter(tvShowArrayList);
        recyclerView.setAdapter(movieAdapter);

        return view;
    }

    private void insertData() {
        for (int i = 0; i < tvShowTitle.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setTitle(tvShowTitle[i]);
            tvShow.setOverview(tvShowOverview[i]);
            tvShow.setReleaseDate(tvShowreleaseDate[i]);
            tvShow.setPoster(tvShowPoster.getResourceId(i, -1));
            tvShow.setDuration(tvShowDuration[i]);
            tvShow.setRating(tvShowRating[i]);
            tvShow.setGenres(tvShowGenre[i]);
            tvShow.setEpisodes(tvShowEpisode[i]);
            tvShow.setBackground(tvShowBackground[i]);
            tvShowArrayList.add(tvShow);
        }

    }

    private void getAllResource() {
        tvShowTitle = getResources().getStringArray(R.array.tv_title);
        tvShowOverview = getResources().getStringArray(R.array.tv_overview);
        tvShowreleaseDate = getResources().getStringArray(R.array.tv_year);
        tvShowPoster = getResources().obtainTypedArray(R.array.tv_poster);
        tvShowDuration = getResources().getStringArray(R.array.tv_duration);
        tvShowRating = getResources().getStringArray(R.array.tv_rating);
        tvShowGenre = getResources().getStringArray(R.array.tv_genres);
        tvShowEpisode = getResources().getStringArray(R.array.tv_current_episode);
        tvShowBackground = getResources().getStringArray(R.array.link_background_tv);
    }

}
