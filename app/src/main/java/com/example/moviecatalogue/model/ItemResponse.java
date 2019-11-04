package com.example.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResponse {
    @SerializedName("results")
    private List<Item> result;

    public List<Item> getResult() {
        return result;
    }

    public void setResult(List<Item> result) {
        this.result = result;
    }


}
