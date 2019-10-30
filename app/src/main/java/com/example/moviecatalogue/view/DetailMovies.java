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
import com.example.moviecatalogue.model.Item;


public class DetailMovies extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "EXTRA_MOVIE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movies);
        Item movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        ImageView moviePoster = findViewById(R.id.detailPoster);
        TextView movieTitle = findViewById(R.id.titleMovie);
        ImageView movieBackground = findViewById(R.id.movieBackground);
        TextView movieRating = findViewById(R.id.ratingScore);
        TextView movieReleaseDate = findViewById(R.id.releaseDate);
        TextView movieOverview = findViewById(R.id.overViewMovie);

        assert movie != null;
        Glide.with(this)
                .load(movie.getPosterPath())
                .into(moviePoster);
        Glide.with(this)
                .load(movie.getBackdropPath())
                .into(movieBackground);
        movieTitle.setText(movie.getTitle());
        movieRating.setText(movie.getVoteAverage());
        movieReleaseDate.setText(getString(R.string.release_date,movie.getReleaseDate()));
        movieOverview.setText(movie.getOverview());


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