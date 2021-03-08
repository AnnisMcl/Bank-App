package com.example.mybankapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMoney{
    //String API_ROUTE = "/accounts/"+id_client;
    String API_ROUTE = "/accounts";
    @GET(API_ROUTE)
    Call<List<Bank_account>> getAllMoney();



}