package com.mramalldo.mvvmkotlinex.data.network

import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interfaz dedicada a las peticiones que se van a realizar a la API*/
interface QuoteApiClient {

    @GET("/quotes")
    suspend fun getAllQuotes(): Response<QuoteModel>
}