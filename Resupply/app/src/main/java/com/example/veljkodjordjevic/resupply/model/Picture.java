package com.example.veljkodjordjevic.resupply.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("url")
    @Expose
    private String url;

    public Picture(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
