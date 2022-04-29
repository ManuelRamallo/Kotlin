package com.mramalldo.mvvmkotlinex.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramalldo.mvvmkotlinex.data.model.ResultModel
import com.mramalldo.mvvmkotlinex.domain.GetQuotesUseCase
import com.mramalldo.mvvmkotlinex.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel(){

    val quoteModel = MutableLiveData<ResultModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate(){
        /*viewModelScope.launch {
            var result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
            }
        }*/
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(result != null) {
                if (!result.results.isNullOrEmpty()) {
                    quoteModel.postValue(result.results[0])
                    isLoading.postValue(false)
                }
            }
        }
    }

    fun randomQuote(){
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote != null){
            quoteModel.postValue(quote)
        }


        isLoading.postValue(false)
    }
}