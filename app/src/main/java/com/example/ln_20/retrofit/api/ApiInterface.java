package com.example.ln_20.retrofit.api;

import com.example.ln_20.retrofit.model.ApiResponse;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ln-20 on 3/2/17.
 */

public interface ApiInterface {
    @GET("json?address=3rd&amp;Lindsley")
    Call<JsonObject> getResults ();
}
