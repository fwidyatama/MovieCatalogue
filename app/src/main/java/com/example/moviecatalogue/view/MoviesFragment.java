package com.example.moviecatalogue.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.adapter.MoviesAdapter;
import com.example.moviecatalogue.model.Item;
import com.example.moviecatalogue.model.ItemResponse;
import com.example.moviecatalogue.viewmodel.MovieViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoviesFragment extends Fragment {
    private RecyclerView recyclerView;
    private MoviesAdapter movieAdapter;
    private ArrayList<Item> itemListArrayList = new ArrayList<>();
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.rv_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MovieViewModel movieViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MovieViewModel.class);
        movieViewModel.getMovieItem().observe(getActivity(), new Observer<ItemResponse>() {
            @Override
            public void onChanged(ItemResponse itemResponse) {
                List<Item> itemLists = itemResponse.getResult();
                itemListArrayList.addAll(itemLists);
                movieAdapter = new MoviesAdapter(getActivity(), itemListArrayList);
                recyclerView.setAdapter(movieAdapter);
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
