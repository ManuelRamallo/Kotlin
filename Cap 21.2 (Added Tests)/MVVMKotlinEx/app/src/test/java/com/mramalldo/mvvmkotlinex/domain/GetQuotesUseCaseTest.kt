package com.mramalldo.mvvmkotlinex.domain

import com.mramalldo.mvvmkotlinex.data.QuoteRepository
import com.mramalldo.mvvmkotlinex.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetQuotesUseCaseTest {

    //@MockK // También está este que es mas compleja pero mas buena, pero puede fallar, es lo mejor pero mas dificil de aprender
    @RelaxedMockK //Esto se encarga de instanciar el elemento
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getQuotesUseCase: GetQuotesUseCase

    // Tod esto se va a ejecutar antes de los test, un metodo generico
    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    @Test
    fun `when The Api Doesnt Return Anything Then Get Values From Database`() =
        runBlocking { //Como vamos a lanzar corrutinas usamos esto para que lo pueda hacer, con poner esto ya funciona
            // Given
            coEvery { quoteRepository.getAllQuotesFromApi() } returns null  // Si esta funcion a la que se le llama (getAllQuotesFromApi) no fuera corrutina solo habría que poner "every" en lugar de "coEvery"

            // When
            getQuotesUseCase()

            // Then
            coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDataBase() } // El exactly mejora la solidez de nuestros test y dice las veces que lo hace
            // Con este metodo pasaría lo mismo que con "coEvery", como es corrutina pues se le pone el "co" delante
        }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        // Given
        val myQuote = Quote("1", 1, 1, 1, 1, emptyList())
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myQuote

        // When
        val response = getQuotesUseCase()

        // Then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuote(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDataBase() } // Con esto verificamos que no se llama a este metodo
        assert(myQuote == response)
    }

}