package com.mramalldo.mvvmkotlinex.data.database.entities

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mramalldo.mvvmkotlinex.domain.model.Result

@Entity(tableName = "result_table")
data class ResultEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idResult") val idResult: Int = 0,

    @ColumnInfo(name = "tags") val tags: List<String>,
    @ColumnInfo(name = "_id") val id: String?,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "authorSlug") val authorSlug: String,
    @ColumnInfo(name = "length") val length: Long,
    @ColumnInfo(name = "dateAdded") val dateAdded: String,
    @ColumnInfo(name = "dateModified") val dateModified: String
)

fun Result.toDataBase() = ResultEntity(
    tags = tags,
    id = id,
    author = author,
    content = content,
    authorSlug = authorSlug,
    length = length,
    dateAdded = dateAdded,
    dateModified = dateModified)
