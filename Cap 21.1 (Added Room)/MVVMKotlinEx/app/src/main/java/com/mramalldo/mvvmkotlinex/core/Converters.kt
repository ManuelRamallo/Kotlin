package com.mramalldo.mvvmkotlinex.core

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mramalldo.mvvmkotlinex.data.database.entities.ResultEntity

class Converters {

    @TypeConverter
    fun listToJson(value: List<ResultEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<ResultEntity>::class.java).toList()

    @TypeConverter
    fun stringToList(value: String?): List<String> {
        val listType = object: TypeToken<ArrayList<String>>(){}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun listToString(list: List<String?>): String {
        return Gson().toJson(list)
    }

}