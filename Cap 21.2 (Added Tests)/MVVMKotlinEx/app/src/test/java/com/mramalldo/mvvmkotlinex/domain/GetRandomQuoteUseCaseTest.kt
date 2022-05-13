package com.mramalldo.mvvmkotlinex.domain

import com.mramalldo.mvvmkotlinex.data.QuoteRepository
import com.mramalldo.mvvmkotlinex.domain.model.Quote
import com.mramalldo.mvvmkotlinex.domain.model.Result
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRandomQuoteUseCaseTest {
    @RelaxedMockK //Esto se encarga de instanciar el elemento
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBeforeCreate() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when database is empty then return null`() = runBlocking {
        // Given
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns null

        // When
        val response = getRandomQuoteUseCase()

        // Then
        assert(response == null)
    }

    @Test
    fun `when database is not empty then return quote`() = runBlocking {
        // Given
        val myQuote = Quote(
            "1", 1, 1, 1, 1, listOf(
                Result(
                    emptyList(), "1", "Manuel Ramallo",
                    "Esto es un unit test", "nose", 1, "hoy", "hoy"
                )
            )
        )
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns myQuote

        // When
        val response = getRandomQuoteUseCase()

        // Then
        assert(response == myQuote.results.first())
    }


}