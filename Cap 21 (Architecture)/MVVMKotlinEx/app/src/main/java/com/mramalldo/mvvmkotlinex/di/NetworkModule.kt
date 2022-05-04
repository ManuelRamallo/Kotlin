package com.mramalldo.mvvmkotlinex.di

import com.mramalldo.mvvmkotlinex.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
* Este modulo nos va a proveer dependencias que no sean tan faciles de proveer como activities u otros objetos,
* Es decir, dependendias de librerias o dependencias de clases que contienen interfaces*/

/**
 * Con el Install In podremos decir cuanto tiempo va a durar esa instancia que hemos creado, lo mas normal es la de actividad, el de view model y el de application
 * El de application normalmente se hace con cosas muy genericas, que se puedan llamar en todas partes, por ejemplo retrofit que se usa en muchos sitios del proyecto*/


@Module
@InstallIn(SingletonComponent::class) // Esto es a nivel de aplicación
object NetworkModule {

    @Singleton // Con esto mantiene una unica instancia, no crea diferentes instancias
    @Provides // Con esto provee cualquier cosa que nosotros queramos, esto siempre tiene que ir puesto
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.quotable.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }

}