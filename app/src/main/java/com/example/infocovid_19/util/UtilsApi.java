package com.example.infocovid_19.util;

public class UtilsApi {

    public static final String BASE_URL_API = "https://siakad.iteba.ac.id/api/";

    /**Mendeklarasikan Interface BaseApiService**/
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
