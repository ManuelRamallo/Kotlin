package com.mramalldo.mvvmkotlinex.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mramalldo.mvvmkotlinex.domain.GetQuotesUseCase
import com.mramalldo.mvvmkotlinex.domain.GetRandomQuoteUseCase
import com.mramalldo.mvvmkotlinex.domain.model.Quote
import com.mramalldo.mvvmkotlinex.domain.model.Result
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class QuoteViewModelTest {

    @RelaxedMockK
    private lateinit var getQuotesUseCse: GetQuotesUseCase

    @RelaxedMockK
    private lateinit var getRandomQuotesUseCase: GetRandomQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    // Reglas
    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    // -----------------------------------

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCse, getRandomQuotesUseCase)

        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at the first time, get all quotes and set the first value`() =
        runTest {
            // Given
            val quote = Quote(
                "1",
                1,
                1,
                1,
                1,
                listOf(
                    Result(
                        emptyList(),
                        "1",
                        "Manuel Ramallo",
                        "Primera cita prueba",
                        "authorslug",
                        1,
                        "date",
                        "dateModified"
                    ),
                    Result(
                        emptyList(),
                        "1",
                        "Reyes Cabo",
                        "Segunda cita prueba",
                        "authorslug",
                        1,
                        "date",
                        "dateModified"
                    )
                )
            )
            coEvery { getQuotesUseCse() } returns quote

            // When
            quoteViewModel.onCreate()

            // Then
            assert(quoteViewModel.quoteModel.value == quote.results.first())
        }

    @Test
    fun `when randomQuoteUseCase return a quote set on the livedata` () = runTest{
        // Given
        var result = Result(
            emptyList(),
            "1",
            "Manuel Ramallo",
            "Otra prueba cita",
            "authorslug",
            1,
            "date",
            "dateModified"
        )
        coEvery { getRandomQuotesUseCase() } returns result


        // When
        quoteViewModel.randomQuote()

        // Then
        assert(quoteViewModel.quoteModel.value == result)

    }

    @Test
    fun `if randomQuoteUseCase return null keep the last value`() = runTest {
        // Given
        var result = Result(
            emptyList(),
            "1",
            "Manuel Ramallo",
            "Otra prueba cita",
            "authorslug",
            1,
            "date",
            "dateModified"
        )
        quoteViewModel.quoteModel.value = result
        coEvery { getRandomQuotesUseCase() } returns null

        // When
        quoteViewModel.randomQuote()

        // Then
        assert(quoteViewModel.quoteModel.value == result)
    }



}