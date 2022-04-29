package com.mramalldo.mvvmkotlinex.domain

import com.mramalldo.mvvmkotlinex.data.model.QuoteProvider
import com.mramalldo.mvvmkotlinex.data.model.ResultModel

class GetRandomQuoteUseCase {

    operator fun invoke(): ResultModel?{

        val quotes = QuoteProvider.quotes
        if(quotes != null){
            val randomNumber = (quotes.results.indices).random() // El indices significa que en lugar de poner (0 until xxx) con el indices ya coge los indices
            return quotes.results[randomNumber]
        }

        return null
    }
}