package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.moviecatalogue.adapter.MovieAdapter;
import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.view.DetailView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] movieTitle;
    private String[] movieOverview;
    private String[] releaseDate;
    private TypedArray moviePoster;
    private String[] movieRating;
    private String[] movieDuration;
    private String[] movieBudget;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movieArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movie);
        listView.setAdapter(movieAdapter);
        getAllResource();
        insertData();
        listView.setOnItemClickListener(this);


    }

    public void getAllResource() {
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieOverview = getResources().getStringArray(R.array.movie_overview);
        releaseDate = getResources().getStringArray(R.array.movie_year);
        moviePoster = getResources().obtainTypedArray(R.array.movie_poster);
        movieDuration = getResources().getStringArray(R.array.movie_duration);
        movieRating = getResources().getStringArray(R.array.movie_rating);
        movieBudget = getResources().getStringArray(R.array.movie_budget);
    }


    public void insertData() {
        movieArrayList = new ArrayList<>();
        for (int i = 0; i < movieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(movieTitle[i]);
            movie.setOverview(movieOverview[i]);
            movie.setReleaseDate(releaseDate[i]);
            movie.setPoster(moviePoster.getResourceId(i, -1));
            movie.setDuration(movieDuration[i]);
            movie.setRating(movieRating[i]);
            movie.setBudget(movieBudget[i]);
            movieArrayList.add(movie);
        }
        movieAdapter.setMovieArrayList(movieArrayList);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Movie movie = new Movie();
        movie.setPoster(movieArrayList.get(i).getPoster());
        movie.setTitle(movieArrayList.get(i).getTitle());
        movie.setDuration(movieArrayList.get(i).getDuration());
        movie.setBudget(movieArrayList.get(i).getBudget());
        movie.setReleaseDate(movieArrayList.get(i).getReleaseDate());
        movie.setRating(movieArrayList.get(i).getRating());
        movie.setOverview(movieArrayList.get(i).getOverview());
        Intent detailIntent = new Intent(MainActivity.this, DetailView.class);
        detailIntent.putExtra(DetailView.EXTRA_MOVIE, movie);
        startActivity(detailIntent);
    }
}
