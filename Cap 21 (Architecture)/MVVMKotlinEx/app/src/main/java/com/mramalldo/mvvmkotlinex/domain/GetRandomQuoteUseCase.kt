package com.mramalldo.mvvmkotlinex.domain

import com.mramalldo.mvvmkotlinex.data.QuoteRepository
import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import com.mramalldo.mvvmkotlinex.data.model.QuoteProvider
import com.mramalldo.mvvmkotlinex.data.model.ResultModel

class GetRandomQuoteUseCase {

    //private val repository = QuoteRepository()

    operator fun invoke(): ResultModel?{

        //repository.getAllQuotes()
        val quotes = QuoteProvider.quotes
        if(quotes != null){
            val randomNumber = (quotes.results.indices).random() // El indices significa que en lugar de poner (0 until xxx) con el indices ya coge los indices
            return quotes.results[randomNumber]
        }

        return null
    }
}