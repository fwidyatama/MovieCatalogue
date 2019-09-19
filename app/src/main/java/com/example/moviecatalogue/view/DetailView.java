package com.example.moviecatalogue.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Movie;

public class DetailView extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    ImageView moviePoster;
    TextView movieTitle;
    TextView movieRating;
    TextView movieBudget;
    TextView movieReleaseDate;
    TextView movieDuration;
    TextView movieOverview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);
        moviePoster = findViewById(R.id.posterMovie);
        movieTitle = findViewById(R.id.titleMovie);
        movieRating = findViewById(R.id.ratingScore);
        movieBudget = findViewById(R.id.budgetMovie);
        movieReleaseDate = findViewById(R.id.releaseDate);
        movieDuration = findViewById(R.id.durationMovie);
        movieOverview = findViewById(R.id.overViewMovie);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        moviePoster.setImageResource(movie.getPoster());
        movieTitle.setText(movie.getTitle());
        movieRating.setText(movie.getRating());
        movieBudget.setText("US$ " + movie.getBudget());
        movieReleaseDate.setText(movie.getReleaseDate());
        movieDuration.setText("Duration : "+movie.getDuration() + " Minutes");
        movieOverview.setText(movie.getOverview());

        getSupportActionBar().hide();



    }
}
