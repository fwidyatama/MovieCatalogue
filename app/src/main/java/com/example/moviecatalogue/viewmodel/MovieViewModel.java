package com.example.moviecatalogue.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviecatalogue.model.ItemResponse;
import com.example.moviecatalogue.repository.RepositoryItem;

public class MovieViewModel extends ViewModel {

    private LiveData<ItemResponse> movieItem;

    public MovieViewModel() {
        RepositoryItem repositoryItem = RepositoryItem.getInstance();
        movieItem = repositoryItem.loadMovies();
    }

    public LiveData<ItemResponse> getMovieItem() {
        return movieItem;
    }


}
