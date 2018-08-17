package com.example.abacus.mvpwithretrofit.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActorsResponse {

    @Expose
    @SerializedName("actors")
    private List<Actors> actors;

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }


}
