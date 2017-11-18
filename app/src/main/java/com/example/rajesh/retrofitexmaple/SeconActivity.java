package com.example.rajesh.retrofitexmaple;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

/**
 * Created by Rajesh on 11/17/2017.
 */

public class SeconActivity {

    public static final String URL_BASIC = "https://jsonplaceholder.typicode.com/posts/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(URL_BASIC).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
