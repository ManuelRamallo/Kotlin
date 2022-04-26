package com.mramalldo.retrofit2corrutinakotlinex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mramalldo.retrofit2corrutinakotlinex.adapters.DogAdapter
import com.mramalldo.retrofit2corrutinakotlinex.databinding.ActivityMainBinding
import com.mramalldo.retrofit2corrutinakotlinex.services.ApiDogService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiDogService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()

            if(call.isSuccessful){
                // show Recycler view
            } else {
                // show error
            }
        }
    }
}