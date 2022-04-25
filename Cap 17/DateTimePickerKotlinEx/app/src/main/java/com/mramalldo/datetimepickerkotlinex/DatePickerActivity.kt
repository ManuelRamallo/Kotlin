package com.mramalldo.datetimepickerkotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mramalldo.datetimepickerkotlinex.databinding.ActivityDatePickerBinding

class DatePickerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI() {
        binding.etDate.setOnClickListener {
            showDatePickerDialog()
        }

        binding.btBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showDatePickerDialog(){
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        binding.etDate.setText("$day / $month / $year")
    }
}