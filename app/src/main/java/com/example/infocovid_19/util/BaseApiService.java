package com.example.infocovid_19.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BaseApiService {

    /*Menu Kasus*/
    @Headers("Content-Type: application/json")
    @GET("covid19")
    Call<JsonArray> getInfoCovid19();
}
