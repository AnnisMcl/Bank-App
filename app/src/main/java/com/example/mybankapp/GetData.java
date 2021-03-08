package com.example.mybankapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData{

    @GET("/config")
    Call<List<User>> getAllAccounts();



}