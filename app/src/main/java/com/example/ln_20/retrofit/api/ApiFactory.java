package com.example.ln_20.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ln-20 on 3/2/17.
 */

public class ApiFactory {
    public ApiFactory() {
    }

    private static final String BASE_URL = "http://maps.googleapis.com/maps/api/geocode/";
    public static Retrofit provideRestAdapter(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
