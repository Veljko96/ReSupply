package com.example.veljkodjordjevic.resupply.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Charity {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("photo")
    @Expose
    private Picture photo;

    @SerializedName("average_rating")
    @Expose
    private int average_rating;

    @SerializedName("rating_count")
    @Expose
    private int rating_count;

    @SerializedName("item_types")
    @Expose
    private List<Item_Type> item_types;


    public Charity(String name, Picture photo, int average_rating, int rating_count, List<Item_Type> item_types) {
        this.name = name;
        this.photo = photo;
        this.average_rating = average_rating;
        this.rating_count = rating_count;
        this.item_types = item_types;
    }

    public String getName() {
        return name;
    }

    public Picture getPhoto() {
        return photo;
    }

    public int getAverage_rating() {
        return average_rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public List<Item_Type> getItem_types() {
        return item_types;
    }
}
