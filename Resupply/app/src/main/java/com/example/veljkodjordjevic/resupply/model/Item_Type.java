package com.example.veljkodjordjevic.resupply.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item_Type {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;


    public Item_Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
