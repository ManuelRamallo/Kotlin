package com.mramalldo.datetimepickerkotlinex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mramalldo.datetimepickerkotlinex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()


    }

    private fun initUi() {
        binding.btDatePicker.setOnClickListener {
            startActivity(Intent(this, DatePickerActivity::class.java))
        }

        binding.btTimePicker.setOnClickListener {
            startActivity(Intent(this, TimePickerActivity::class.java))
        }
    }
}