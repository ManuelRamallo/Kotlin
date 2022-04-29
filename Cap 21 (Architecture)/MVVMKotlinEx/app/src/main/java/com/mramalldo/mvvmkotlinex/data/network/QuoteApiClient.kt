package com.mramalldo.mvvmkotlinex.data.network

import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    /*@GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>*/

    @GET("/quotes")
    suspend fun getAllQuotes(): Response<QuoteModel>
}