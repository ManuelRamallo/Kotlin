package com.mramalldo.mvvmkotlinex.domain

import com.mramalldo.mvvmkotlinex.data.QuoteRepository
import com.mramalldo.mvvmkotlinex.data.database.entities.toDataBase
import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import com.mramalldo.mvvmkotlinex.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository){

    // Este caso de uso lo realiza solo cuando abre la primera vez la app, asi que lo suyo es que recupere de la API los datos
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes != null) {
            repository.clearQuotes()
            repository.insertQuote(quotes.toDataBase())
            quotes
        } else {
            repository.getAllQuotesFromDataBase()
        }
    }

}