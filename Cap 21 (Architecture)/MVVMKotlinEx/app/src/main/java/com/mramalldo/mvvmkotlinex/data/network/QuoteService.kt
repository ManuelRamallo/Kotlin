package com.mramalldo.mvvmkotlinex.data.network

import com.mramalldo.mvvmkotlinex.core.RetrofitHelper
import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    /*suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }*/

    suspend fun getQuotes():QuoteModel{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: QuoteModel("1", 1, 1, 1, 1, emptyList())
        }
    }

}