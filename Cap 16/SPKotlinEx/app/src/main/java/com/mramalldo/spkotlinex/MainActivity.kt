package com.mramalldo.spkotlinex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mramalldo.spkotlinex.SPKotlinExApplication.Companion.prefs
import com.mramalldo.spkotlinex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()
        checkUserValues()
    }

    private fun checkUserValues() {
        if(prefs.getName().isNotEmpty()) {
            goToDetail()
        }
    }

    private fun initUi() {
        binding.btContinue.setOnClickListener {
            accessToDetails()
        }
    }

    private fun accessToDetails() {
        if(binding.etName.text.isNotEmpty()) {
            prefs.saveName(binding.etName.text.toString())
            prefs.saveVIP(binding.cbVIP.isChecked)
            goToDetail()
        } else {
            Toast.makeText(this, "Lo siento pero no puedes ir a la siguiente pantalla si no escribes alguna información", Toast.LENGTH_SHORT).show()
        }
    }

    fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }
}