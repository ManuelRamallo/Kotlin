package com.mramalldo.mvvmkotlinex.data

import com.mramalldo.mvvmkotlinex.data.model.QuoteModel
import com.mramalldo.mvvmkotlinex.data.model.QuoteProvider
import com.mramalldo.mvvmkotlinex.data.network.QuoteService
import javax.inject.Inject

/**
 * Clase encargarda de acceder a la clase de base de datos o a la API para recoger los datos.
 * Si accedemos a la parte de network o accedemos a la parte de DataBase*/
class QuoteRepository @Inject constructor( private val api: QuoteService, private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes():QuoteModel{
        val response = api.getQuotes() // Primero obtenemos desde la corrutina del backend  y recupero las citas
        quoteProvider.quotes = response // Guardamos aquí la respuesta del servidor (ahora mismo esto funciona como una base de datos local almacenando en memoria)
        return response // Devolvemos la respuesta
    }

}