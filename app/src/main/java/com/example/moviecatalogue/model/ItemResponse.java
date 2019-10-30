package com.example.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResponse {
    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<Item> result;

    @SerializedName("total_results")
    private int totalResult;

    @SerializedName("total_pages")
    private int totalPages;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Item> getResult() {
        return result;
    }

    public void setResult(List<Item> result) {
        this.result = result;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
