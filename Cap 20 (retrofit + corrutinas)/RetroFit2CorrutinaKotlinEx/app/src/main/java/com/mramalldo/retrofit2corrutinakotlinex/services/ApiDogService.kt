package com.mramalldo.retrofit2corrutinakotlinex.services

import com.mramalldo.retrofit2corrutinakotlinex.models.DogResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiDogService {
    @GET
    suspend fun getDogsByBreeds(@Url url:String): Response<DogResponse>

    @GET("/example/example2/{id}/algo")
    suspend fun getDogsByBreeds2(@Path("id") id: String): Response<DogResponse>

    @GET("/example/example2/v2/algo")
    suspend fun getDogsByBreeds3(@Query("pet") pet: String, @Query("name") name: String): Response<DogResponse>

    @POST
    fun getEverything(@Body exampleNameDto: ExampleNameDto): Call<*>

    @Multipart
    @POST
    fun getEverything2(@Part image: MultipartBody.Part, @Part("example") myExample:String): Call<*>

    // Para convertir un fichero a multipart body
    // val requestBody = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file)
    // val a = MultipartBody.Part.createFormData("picture", file.getName(), requestBody)

}

data class ExampleNameDto(val name: String, val age: Int)