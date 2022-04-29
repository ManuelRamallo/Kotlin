package com.mramalldo.mvvmkotlinex.data

import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import com.mramalldo.mvvmkotlinex.data.model.QuoteProvider
import com.mramalldo.mvvmkotlinex.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    /*suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }*/

    suspend fun getAllQuotes():QuoteModel{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }

}