package com.example.moviecatalogue.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviecatalogue.api.ApiClient;
import com.example.moviecatalogue.model.ItemResponse;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<ItemResponse> movieList;
    private ApiClient movieClient = new ApiClient();

    public LiveData<ItemResponse> getMovies() {
        if (movieList == null) {
            movieList = new MutableLiveData<>();
            loadMovies();
        }
        return movieList;
    }

    private void loadMovies() {

        Log.d("Bahasa", Locale.getDefault().getDisplayLanguage());
        Call<ItemResponse> call;
        if (Locale.getDefault().getDisplayLanguage().equals("English")) {
            call = movieClient.init().getMovieList("en");
        } else {
            call = movieClient.init().getMovieList("id");
        }

        call.enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                movieList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                Log.d("Status", "Failed");
            }
        });
    }
}
