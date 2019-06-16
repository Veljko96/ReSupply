package com.example.veljkodjordjevic.resupply.model;

import java.util.List;

public class CharitiesResponse {

    private List<Charity> charities;

    public CharitiesResponse(List<Charity> charities) {
        this.charities = charities;
    }

    public List<Charity> getCharities() {
        return charities;
    }
}
