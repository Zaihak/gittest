package com.example.hankomin.wikiapp;

public class WikiSearch {
    private String title;
    private String snippet;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet.replaceAll("\\<.*?\\>", "");
    }

    public void setSnippet(String snippet) {

        this.snippet = snippet;
    }
}
