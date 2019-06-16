package com.example.veljkodjordjevic.resupply.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Role {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("refresh_token")
    @Expose
    private String refresh_token;

    public Role(String type, String token, String refresh_token) {
        this.type = type;
        this.token = token;
        this.refresh_token = refresh_token;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
