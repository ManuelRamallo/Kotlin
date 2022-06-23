package com.mramalldo.mvvmkotlinex.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramalldo.mvvmkotlinex.domain.GetQuotesUseCase
import com.mramalldo.mvvmkotlinex.domain.GetRandomQuoteUseCase
import com.mramalldo.mvvmkotlinex.domain.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<Result?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getQuotesUseCase()

            if (!quote?.results.isNullOrEmpty()) {
                if (quote != null) {
                    quoteModel.postValue(quote.results[0])
                }
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote)
            }


            isLoading.postValue(false)
        }
    }
}