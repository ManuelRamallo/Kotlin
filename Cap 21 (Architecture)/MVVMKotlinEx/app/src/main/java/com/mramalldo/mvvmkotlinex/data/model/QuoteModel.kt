package com.mramalldo.mvvmkotlinex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/*data class QuoteModel(@SerializedName("quote") val quote: String, @SerializedName("author") val author: String)*/

@Serializable
data class QuoteModel (
    val count: String,
    val totalCount: Long,
    val page: Long,
    val totalPages: Long,
    val lastItemIndex: Long,
    val results: List<ResultModel>
)
