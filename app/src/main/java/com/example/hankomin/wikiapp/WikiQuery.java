package com.example.hankomin.wikiapp;

import java.util.ArrayList;

public class WikiQuery {
    public ArrayList<WikiSearch> getSearch() {
        return search;
    }

    public void setSearch(ArrayList<WikiSearch> search) {
        this.search = search;
    }

    private ArrayList<WikiSearch> search;
}
