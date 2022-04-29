package com.mramalldo.mvvmkotlinex.domain

import com.mramalldo.mvvmkotlinex.data.QuoteRepository
import com.mramalldo.mvvmkotlinex.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    /*suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()*/
    suspend operator fun invoke():QuoteModel? = repository.getAllQuotes()

}