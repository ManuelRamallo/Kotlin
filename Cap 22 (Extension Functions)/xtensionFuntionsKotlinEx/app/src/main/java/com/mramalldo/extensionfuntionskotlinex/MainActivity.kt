package com.mramalldo.extensionfuntionskotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.mramalldo.extensionfuntionskotlinex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MAINACTIVITY"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = "Manuel"
        var happyName = name.happy()
        Log.d(TAG, "onCreate: $happyName")

        // Esto ya valdría para pasarlo en cualquier sitio, nos ahorramos el contextCompat y eso
        R.color.black

        val age:Int? = null

        if(age.isNull()){
            // Haríamos algo
        }

        toast("Ejemplo 1")
        toast("Ejemplo 2", Toast.LENGTH_LONG)

        binding.example.loadImage("")

        binding.etExample.onTextChanged { texto ->
            toast("El texto contiene $texto")
        }
    }
}