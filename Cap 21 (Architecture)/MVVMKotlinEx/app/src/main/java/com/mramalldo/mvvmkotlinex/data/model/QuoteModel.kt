package com.mramalldo.mvvmkotlinex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class QuoteModel (
    val count: String,
    val totalCount: Long,
    val page: Long,
    val totalPages: Long,
    val lastItemIndex: Long,
    val results: List<ResultModel>
)
