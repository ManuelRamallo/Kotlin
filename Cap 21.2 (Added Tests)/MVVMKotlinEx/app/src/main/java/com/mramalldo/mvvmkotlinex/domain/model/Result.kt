package com.mramalldo.mvvmkotlinex.domain.model

import com.mramalldo.mvvmkotlinex.data.database.entities.ResultEntity
import com.mramalldo.mvvmkotlinex.data.model.ResultModel
import kotlinx.serialization.SerialName

data class Result(
    val tags: List<String>,
    val id: String?,
    val author: String,
    val content: String,
    val authorSlug: String,
    val length: Long,
    val dateAdded: String,
    val dateModified: String
)

fun ResultModel.toDomain() = Result(tags, id, author, content, authorSlug, length, dateAdded, dateModified)
fun ResultEntity.toDomain() = Result(tags, id, author, content, authorSlug, length, dateAdded, dateModified)
