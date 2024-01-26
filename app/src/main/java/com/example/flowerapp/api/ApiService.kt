package com.example.flowerapp.api

import com.example.flowerapp.model.Result
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("testUrlVer1.1")
    suspend fun getItems(): Response<Result>


}