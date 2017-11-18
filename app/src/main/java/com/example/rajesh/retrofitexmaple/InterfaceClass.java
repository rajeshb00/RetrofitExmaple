package com.example.rajesh.retrofitexmaple;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Rajesh on 11/17/2017.
 */

public interface InterfaceClass {

    @GET(".")
    Call<List<Datum>> getListData();

}
