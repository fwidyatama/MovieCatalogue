package com.example.moviecatalogue.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.adapter.TvAdapter;
import com.example.moviecatalogue.model.Item;
import com.example.moviecatalogue.model.ItemResponse;
import com.example.moviecatalogue.viewmodel.TvViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TvShowFragment extends Fragment {
    private RecyclerView recyclerView;
    private TvAdapter tvAdapter;
    private TvViewModel tvViewModel;
    private ArrayList<Item> itemListArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_tvShow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tvViewModel = new ViewModelProvider(Objects.requireNonNull(getActivity()), new ViewModelProvider.NewInstanceFactory()).get(TvViewModel.class);
        tvViewModel.getMovies().observe(getActivity(), new Observer<ItemResponse>() {
            @Override
            public void onChanged(ItemResponse itemResponse) {
                List<Item> itemLists = itemResponse.getResult();
                itemListArrayList.addAll(itemLists);
                tvAdapter = new TvAdapter(getActivity(), itemListArrayList);
                recyclerView.setAdapter(tvAdapter);
            }
        });
    }


}