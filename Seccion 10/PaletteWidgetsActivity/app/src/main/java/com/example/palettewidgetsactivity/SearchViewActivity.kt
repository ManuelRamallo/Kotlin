package com.example.palettewidgetsactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class SearchViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

        val users = arrayOf("Alberto", "Alvaro", "Ana", "Amparo", "Bartolo", "Bernardo", "Carla", "Carlos", "Carolina")
        val adapterUsers : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)

        var svUsers = findViewById<SearchView>(R.id.svUsers)
        var lvUsers = findViewById<ListView>(R.id.lvUsers)


        lvUsers.adapter = adapterUsers

        svUsers.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                svUsers.clearFocus()
                if (users.contains(query))  adapterUsers.filter.filter(query)
                return false

            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapterUsers.filter.filter(query)
                return false
            }

        })

    }
}