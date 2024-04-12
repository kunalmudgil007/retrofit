package com.example.apixml

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("getScannedInbound")
    fun getData():Call<List<MyDataItem>>




}