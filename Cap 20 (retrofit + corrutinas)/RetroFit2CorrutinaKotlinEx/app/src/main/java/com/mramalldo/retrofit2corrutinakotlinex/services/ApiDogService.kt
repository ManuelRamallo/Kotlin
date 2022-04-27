package com.mramalldo.retrofit2corrutinakotlinex.services

import com.mramalldo.retrofit2corrutinakotlinex.models.DogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiDogService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogResponse>

}