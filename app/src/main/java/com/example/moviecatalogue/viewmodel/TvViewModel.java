package com.example.moviecatalogue.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviecatalogue.model.ItemResponse;
import com.example.moviecatalogue.repository.RepositoryItem;


public class TvViewModel extends ViewModel {

    private LiveData<ItemResponse> movieItem;

    public TvViewModel() {

        RepositoryItem repositoryItem = RepositoryItem.getInstance();
        movieItem = repositoryItem.loadTv();
    }

    public LiveData<ItemResponse> getTvItem() {
        return movieItem;
    }
}
