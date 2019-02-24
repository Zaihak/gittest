package com.example.hankomin.wikiapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GenericDeserializer<T> {
    private Class<T> type;

    public GenericDeserializer(Class<T> type) {
        this.type = type;
    }
    public T parse(String jsonText){
        Gson gson=new GsonBuilder().create();
        return gson.fromJson(jsonText,type);
    }
}
