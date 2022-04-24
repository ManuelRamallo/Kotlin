package com.mramalldo.rvkotlinex

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mramalldo.rvkotlinex.adapters.SuperHeroAdapter
import com.mramalldo.rvkotlinex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)

        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.rvSuperhero.layoutManager = manager
        binding.rvSuperhero.adapter =
            SuperHeroAdapter(SuperHeroProvider.superHeroList) { superHero ->
                onItemSelected(
                    superHero
                )
            }
        binding.rvSuperhero.addItemDecoration(decoration)
    }

    fun onItemSelected(superhero: SuperHero) {
        Toast.makeText(this, superhero.toString(), Toast.LENGTH_SHORT).show()
    }
}