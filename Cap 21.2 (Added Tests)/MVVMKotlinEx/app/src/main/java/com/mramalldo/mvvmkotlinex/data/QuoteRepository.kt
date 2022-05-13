package com.mramalldo.mvvmkotlinex.data

import com.mramalldo.mvvmkotlinex.data.database.dao.QuoteDao
import com.mramalldo.mvvmkotlinex.data.database.entities.QuoteEntity
import com.mramalldo.mvvmkotlinex.data.network.QuoteService
import com.mramalldo.mvvmkotlinex.domain.model.Quote
import com.mramalldo.mvvmkotlinex.domain.model.toDomain
import javax.inject.Inject

/**
 * Clase encargarda de acceder a la clase de base de datos o a la API para recoger los datos.
 * Si accedemos a la parte de network o accedemos a la parte de DataBase*/
class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): Quote? {
        val response = api.getQuotes() // Primero obtenemos desde la corrutina del backend  y recupero las citas
        return response?.toDomain()// Devolvemos la respuesta
    }

    suspend fun getAllQuotesFromDataBase(): Quote? {
        val response = quoteDao.getAllQuotes()
        return response?.toDomain()
    }

    suspend fun insertQuote(quote: QuoteEntity) {
        quoteDao.insertAll(quote)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }

}