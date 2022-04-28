package com.mramalldo.extensionfuntionskotlinex

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

fun String.happy():String = "$this :)"

// Método para devolver el color
fun Activity.color(@ColorRes color:Int) = ContextCompat.getColor(this, color);

// Método para hacer comprobaciones de nulos, devuelve un boolean para saber si es o no nulo
fun Any?.isNull() = this == null

fun Activity.toast(text:String, lenght:Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, lenght).show()

fun ImageView.loadImage(url:String) {
    if(url.isNotEmpty()){
        Glide.with(this.context).load(url).into(this)
    }
}

fun EditText.onTextChanged(listener:(String) -> Unit) {
    this.addTextChangedListener(object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            listener(p0.toString())
        }
    })
}

