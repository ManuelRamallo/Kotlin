package com.mramalldo.mvvmkotlinex.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mramalldo.mvvmkotlinex.data.database.entities.QuoteEntity

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote_table")
    suspend fun getAllQuotes():QuoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quote: QuoteEntity)

    @Query("DELETE FROM quote_table")
    suspend fun deleteAllQuotes()

}