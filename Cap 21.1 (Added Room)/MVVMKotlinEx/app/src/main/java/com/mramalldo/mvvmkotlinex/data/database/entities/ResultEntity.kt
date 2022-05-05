package com.mramalldo.mvvmkotlinex.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.mramalldo.mvvmkotlinex.domain.model.Result

@Entity(tableName = "result_table")
data class ResultEntity(
    @ColumnInfo(name = "tags") val tags: List<String>,
    @ColumnInfo(name = "_id") val id: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "authorSlug") val authorSlug: String,
    @ColumnInfo(name = "length") val length: Long,
    @ColumnInfo(name = "dateAdded") val dateAdded: String,
    @ColumnInfo(name = "dateModified") val dateModified: String
)

fun Result.toDataBase() = ResultEntity(tags, id, author, content, authorSlug, length, dateAdded, dateModified)
