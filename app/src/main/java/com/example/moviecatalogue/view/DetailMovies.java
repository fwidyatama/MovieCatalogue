package com.example.moviecatalogue.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Movie;

public class DetailMovies extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    private ImageView moviePoster;
    private ImageView movieBackground;
    private TextView movieTitle;
    private TextView movieRating;
    private TextView movieBudget;
    private TextView movieReleaseDate;
    private TextView movieDuration;
    private TextView movieOverview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movies);
        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        moviePoster = findViewById(R.id.detailPoster);
        moviePoster.setImageResource(movie.getPoster());
        movieTitle = findViewById(R.id.titleMovie);
        movieBackground = findViewById(R.id.movieBackground);
        movieRating = findViewById(R.id.ratingScore);
        movieBudget = findViewById(R.id.budgetMovie);
        movieReleaseDate = findViewById(R.id.releaseDate);
        movieDuration = findViewById(R.id.durationMovie);
        movieOverview = findViewById(R.id.overViewMovie);


        movieTitle.setText(movie.getTitle());
        movieRating.setText(movie.getRating());
        movieBudget.setText(getString(R.string.budget, movie.getBudget()));
        movieReleaseDate.setText(getString(R.string.release, movie.getReleaseDate()));
        movieDuration.setText(getString(R.string.duration, movie.getDuration()));
        movieOverview.setText(movie.getOverview());
        Glide.with(this).load(movie.getBackground()).into(movieBackground);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(movie.getTitle());
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }
}