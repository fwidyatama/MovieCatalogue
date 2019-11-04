package com.example.moviecatalogue.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moviecatalogue.api.ApiClient;
import com.example.moviecatalogue.model.ItemResponse;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryItem {
    private ApiClient movieClient = new ApiClient();

    private static volatile RepositoryItem INSTANCE;

    public static RepositoryItem getInstance() {
        if (INSTANCE == null) {
            synchronized (RepositoryItem.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RepositoryItem();
                }
            }
        }
        return INSTANCE;
    }

    public MutableLiveData<ItemResponse> loadMovies() {
        final MutableLiveData<ItemResponse> listItem = new MutableLiveData<>();
        Call<ItemResponse> call;
        if (Locale.getDefault().getDisplayLanguage().equals("English")) {
            call = movieClient.init().getMovieList("en");
        } else {
            call = movieClient.init().getMovieList("id");
        }
        call.enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                listItem.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                Log.d("Status", "Failed");
            }
        });
        return listItem;
    }


    public MutableLiveData<ItemResponse> loadTv() {
        final MutableLiveData<ItemResponse> listItem = new MutableLiveData<>();
        Call<ItemResponse> call;
        if (Locale.getDefault().getDisplayLanguage().equals("English")) {
            call = movieClient.init().getTvShowList("en");
        } else {
            call = movieClient.init().getTvShowList("id");
        }
        call.enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                listItem.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                Log.d("Status", "Failed");
            }
        });
        return listItem;
    }

}
