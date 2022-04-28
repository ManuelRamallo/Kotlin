package com.mramalldo.mvvmkotlinex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mramalldo.mvvmkotlinex.model.QuoteModel
import com.mramalldo.mvvmkotlinex.model.QuoteProvider

class QuoteViewModel: ViewModel(){

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}