package com.mramalldo.mvvmkotlinex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultModel(
    val tags: List<String>,

    @SerialName("_id")
    val id: String,

    val author: String,
    val content: String,
    val authorSlug: String,
    val length: Long,
    val dateAdded: String,
    val dateModified: String
)
