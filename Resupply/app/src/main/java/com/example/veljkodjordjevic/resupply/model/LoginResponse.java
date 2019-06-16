package com.example.veljkodjordjevic.resupply.model;

import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LoginResponse {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("roles")
    @Expose
    private List<Role> roles;

    public LoginResponse(int id, User user, List<Role> roles) {
        this.id = id;
        this.user = user;
        this.roles = roles;
    }

    private int getId() {return id;}

    public User getUser() {
        return user;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
