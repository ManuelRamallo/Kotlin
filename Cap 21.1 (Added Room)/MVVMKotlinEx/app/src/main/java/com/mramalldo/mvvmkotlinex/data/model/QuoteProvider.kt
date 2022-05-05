package com.mramalldo.mvvmkotlinex.data.model

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Se añade el TAG Singleton porque al crear una dependencia lo que hace es crear una cuando se recogen los datos de la api llamandolo
 * en el repositorty que es donde guarda los datos, el problema es que cuando lo llamammos desde el caso de uso random crea otra instancia que estará
 * vacío sin datos porque habrá 2 instancias creadas, una con datos y otra sin datos, para eso añadimos el parametro singleton*/

@Singleton
class QuoteProvider @Inject constructor(){
        var quotes:QuoteModel? = null
}