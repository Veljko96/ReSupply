package com.example.veljkodjordjevic.resupply.model;

public class LoginData {

    private String email;
    private String password;
    private String scope;
    private String provider;


    public LoginData(String email, String password, String scope, String provider) {
        this.email = email;
        this.password = password;
        this.scope = scope;
        this.provider = provider;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getScope() {
        return scope;
    }

    public String getProvider() {
        return provider;
    }
}
