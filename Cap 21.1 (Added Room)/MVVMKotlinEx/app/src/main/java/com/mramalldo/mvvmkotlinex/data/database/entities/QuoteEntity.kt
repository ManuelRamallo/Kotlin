package com.mramalldo.mvvmkotlinex.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mramalldo.mvvmkotlinex.domain.model.Quote

@Entity(tableName = "quote_table")
data class QuoteEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,

    @ColumnInfo(name = "count") val count: String,
    @ColumnInfo(name = "totalCount") val totalCount: Long,
    @ColumnInfo(name = "page") val page: Long,
    @ColumnInfo(name = "totalPages") val totalPages: Long,
    @ColumnInfo(name = "lastItemIndex") val lastItemIndex: Long,
    @ColumnInfo(name = "results") val results: List<ResultEntity>
)

fun Quote.toDataBase() =
    QuoteEntity(
        count = count,
        totalCount = totalCount,
        page = page,
        totalPages = totalPages,
        lastItemIndex = lastItemIndex,
        results = results.map { it.toDataBase()}
    )