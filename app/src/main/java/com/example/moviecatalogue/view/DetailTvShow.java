package com.example.moviecatalogue.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.TvShow;

public class DetailTvShow extends AppCompatActivity {
    public static final String EXTRA_TVSHOW = "extra_tvshow";
    private ImageView tvShowPoster;
    private ImageView tvShowBackground;
    private TextView tvShowTitle;
    private TextView tvShowRating;
    private TextView tvShowGenre;
    private TextView tvShowYear;
    private TextView tvShowEpisode;
    private TextView tvShowDuration;
    private TextView tvShowOverview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tvshow);
        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TVSHOW);

        tvShowBackground = findViewById(R.id.tvshow_Background);
        tvShowPoster = findViewById(R.id.tvPoster);
        tvShowTitle = findViewById(R.id.title_tvShow);
        tvShowRating = findViewById(R.id.ratingScore_tvshow);
        tvShowGenre = findViewById(R.id.genre);
        tvShowYear = findViewById(R.id.yearRelease_tvshow);
        tvShowEpisode = findViewById(R.id.episode);
        tvShowDuration = findViewById(R.id.durationtvShow);
        tvShowOverview = findViewById(R.id.overViewtvShow);

        tvShowPoster.setImageResource(tvShow.getPoster());
        Glide.with(this).load(tvShow.getBackground()).into(tvShowBackground);
        tvShowTitle.setText(tvShow.getTitle());
        tvShowRating.setText(tvShow.getRating());
        tvShowGenre.setText(getString(R.string.genre, tvShow.getGenres()));
        tvShowYear.setText(getString(R.string.release, tvShow.getReleaseDate()));
        tvShowEpisode.setText(getString(R.string.episode, tvShow.getEpisodes()));
        tvShowDuration.setText(getString(R.string.duration, tvShow.getDuration()));
        tvShowOverview.setText(tvShow.getOverview());


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(tvShow.getTitle());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
}

