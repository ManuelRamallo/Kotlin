package com.mramalldo.mvvmkotlinex.domain

import com.mramalldo.mvvmkotlinex.data.model.QuoteProvider
import com.mramalldo.mvvmkotlinex.data.model.ResultModel
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke(): ResultModel?{
        val quotes = quoteProvider.quotes
        if(quotes != null){
            val randomNumber = (quotes.results.indices).random() // El indices significa que en lugar de poner (0 until xxx) con el indices ya coge los indices
            return quotes.results[randomNumber]
        }

        return null
    }
}