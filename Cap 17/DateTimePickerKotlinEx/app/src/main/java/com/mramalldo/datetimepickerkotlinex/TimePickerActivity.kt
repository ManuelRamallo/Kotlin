package com.mramalldo.datetimepickerkotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mramalldo.datetimepickerkotlinex.databinding.ActivityTimePickerBinding

class TimePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        binding.etTime.setOnClickListener {
            showTimePickerDialog()
        }

        binding.btBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showTimePickerDialog(){
        val timePicker = TimePickerFragment {onTimeSelected(it) }
        timePicker.show(supportFragmentManager, "timePicker")
    }

    private fun onTimeSelected(time:String) {
        binding.etTime.setText("$time")
    }
}