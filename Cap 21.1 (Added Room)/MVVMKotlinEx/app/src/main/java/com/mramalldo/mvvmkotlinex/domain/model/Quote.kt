package com.mramalldo.mvvmkotlinex.domain.model

import com.mramalldo.mvvmkotlinex.data.database.entities.QuoteEntity
import com.mramalldo.mvvmkotlinex.data.model.QuoteModel

data class Quote(
    val count: String,
    val totalCount: Long,
    val page: Long,
    val totalPages: Long,
    val lastItemIndex: Long,
    val results: List<Result>
)

fun QuoteModel.toDomain() = Quote(count, totalCount, page, totalPages, lastItemIndex, results.map { it.toDomain()})
fun QuoteEntity.toDomain() = Quote(count, totalCount, page, totalPages, lastItemIndex, results.map { it.toDomain()})
