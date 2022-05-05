package com.mramalldo.mvvmkotlinex.data.network

import com.mramalldo.mvvmkotlinex.core.RetrofitHelper
import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Clase dedicada a obtener la respuesta de la petición a la API y transmitir esa respuesta*/
class QuoteService @Inject constructor( private val apiClient: QuoteApiClient) {

    //private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():QuoteModel{
        return withContext(Dispatchers.IO) {
            // Esto comentado era antes sin usar Dagger Hilt
            // val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            val response = apiClient.getAllQuotes()
            response.body() ?: QuoteModel("1", 1, 1, 1, 1, emptyList())
        }
    }

}