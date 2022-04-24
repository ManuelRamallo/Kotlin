package com.mramalldo.spkotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.mramalldo.spkotlinex.SPKotlinExApplication.Companion.prefs
import com.mramalldo.spkotlinex.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        binding.btClose.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
        binding.tvName.text = prefs.getName()
        if(prefs.getVIP()){
            setVIPColorBackground()
        }
    }

    private fun setVIPColorBackground(){
        binding.llContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
    }
}