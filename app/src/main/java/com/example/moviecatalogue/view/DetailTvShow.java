package com.example.moviecatalogue.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.moviecatalogue.R;
import com.example.moviecatalogue.model.Item;

public class DetailTvShow extends AppCompatActivity {
    public static final String EXTRA_TV_SHOW = "EXTRA_TV_SHOW";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tvshow);
        Item tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        ImageView tvShowBackground = findViewById(R.id.tvshow_Background);
        ImageView tvShowPoster = findViewById(R.id.tvPoster);
        TextView tvShowTitle = findViewById(R.id.title_tvShow);
        TextView tvShowRating = findViewById(R.id.ratingScore_tvshow);
        TextView tvShowYear = findViewById(R.id.yearRelease_tvshow);
        TextView tvShowOverview = findViewById(R.id.overViewtvShow);

        assert tvShow != null;
        Glide.with(this)
                .load(tvShow.getPosterPath())
                .into(tvShowPoster);
        Glide.with(this)
                .load(tvShow.getBackdropPath())
                .into(tvShowBackground);
        tvShowTitle.setText(tvShow.getOriginalName());
        tvShowRating.setText(tvShow.getVoteAverage());
        tvShowYear.setText(getString(R.string.release_date, tvShow.getFirstAirDate()));
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

