package com.example.abacus.mvpwithretrofit.data.network.service;

import com.example.abacus.mvpwithretrofit.data.network.model.ActorsResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ActorService {

    private static final String URL = "http://microblogging.wingnity.com/JSONParsingTutorial/";

    private ActorsApi mMovieApi;

    public ActorService()
    {
        Retrofit mRetrofit = new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).baseUrl(URL).build();

        mMovieApi = mRetrofit.create(ActorsApi.class);
    }

    public ActorsApi getmMovieApi() {
        return mMovieApi;
    }

    public interface ActorsApi
    {
        @GET("jsonActors")
        Call<ActorsResponse> getAllActors();
    }
}
