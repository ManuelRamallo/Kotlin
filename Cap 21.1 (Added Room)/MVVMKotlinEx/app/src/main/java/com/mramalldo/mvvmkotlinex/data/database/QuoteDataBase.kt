package com.mramalldo.mvvmkotlinex.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mramalldo.mvvmkotlinex.core.Converters
import com.mramalldo.mvvmkotlinex.data.database.dao.QuoteDao
import com.mramalldo.mvvmkotlinex.data.database.entities.QuoteEntity
import com.mramalldo.mvvmkotlinex.data.database.entities.ResultEntity

@Database(entities = [QuoteEntity::class, ResultEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class QuoteDataBase: RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao
}