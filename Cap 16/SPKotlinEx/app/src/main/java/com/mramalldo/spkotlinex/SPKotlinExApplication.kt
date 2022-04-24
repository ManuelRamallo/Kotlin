package com.mramalldo.spkotlinex

import android.app.Application
import android.os.Bundle

class SPKotlinExApplication: Application() {

    companion object {
        lateinit var prefs:Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)

    }
}