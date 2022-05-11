package com.mramalldo.mvvmkotlinex.domain

import android.util.Log
import com.mramalldo.mvvmkotlinex.data.QuoteRepository
import com.mramalldo.mvvmkotlinex.domain.model.Result
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke(): Result?{
        val quotes = repository.getAllQuotesFromDataBase()
        if(quotes != null){
            val randomNumber = (quotes.results.indices).random() // El indices significa que en lugar de poner (0 until xxx) con el indices ya coge los indices
            return quotes.results[randomNumber]
        }

        return null
    }
}