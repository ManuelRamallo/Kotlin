package com.example.palettewidgetsactivity

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import java.lang.Thread.sleep
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityContext = this


        var ivEjemplo = findViewById<ImageView>(R.id.ivEjemplo)



        val imageURL = "http://jotajotavm.com/img/PREMIUM-AndroidDevelopment.gif"
        //Picasso.get().load(imageURL).into(ivEjemplo)
        /*
        PARA USAR PICASSO AL CARGAR LA IMAGEN HAY QUE AÑADIR EN EL GRADLE LA SIGUIENTE LINEA
        implementation 'com.squareup.picasso:picasso:2.71828'


        Y DAR PERMISOS EN EL MANIFEST CON LA SIGUIENTE LINEA
        <uses-permission android:name="android.permission.INTERNET" />
         */


        var webView = findViewById<WebView>(R.id.webView)
        var webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
        webView.setWebViewClient(WebViewClient())

        webView.loadUrl("http://www.google.com")

        /*
        PARA USAR EL WEBVIEW HAY QUE DAR PERMISOS EN EL MANIFEST CON LA SIGUIENTE LINEA
        <uses-permission android:name="android.permission.INTERNET" />
         */

        var vvLocal = findViewById<VideoView>(R.id.vvLocal)
        var mcLocal = MediaController(this)
        mcLocal.setAnchorView(vvLocal)
        //var path = "android.resource://" + packageName + "/" + R.raw.video
        //vvLocal.setVideoURI(Uri.parse(path))
        vvLocal.setMediaController(mcLocal)
        //vvLocal.start()


        var vvWeb = findViewById<VideoView>(R.id.vvWeb)
        var mcWeb = MediaController(this)

        mcWeb.setAnchorView(vvWeb)
        vvWeb.setVideoPath("https://jotajotavm.com/img/video.mp4")
        vvWeb.setMediaController(mcWeb)

        /*
        PARA CARGAR UN VIDEO DE UNA DIRECCION WEB HAY QUE DAR PERMISOS EN EL MANIFEST CON LA SIGUIENTE LINEA
        <uses-permission android:name="android.permission.INTERNET" />
         */


        var cvEjemplo = findViewById<CalendarView>(R.id.cvEjemplo)
        var tvFecha = findViewById<TextView>(R.id.tvFecha)
        cvEjemplo.setOnDateChangeListener { cv, year, month, day ->
            var date = "$day/${month+1}/$year"
            tvFecha.text = "Fecha seleccionada: $date"
        }

        var calendar = Calendar.getInstance()
        calendar.set(2026, 5-1, 8)
        cvEjemplo.date = calendar.timeInMillis


        var d = cvEjemplo.firstDayOfWeek
        cvEjemplo.firstDayOfWeek = (d+1) % 7


        /*var rbEjemplo = findViewById<RatingBar>(R.id.rbEjemplo)
        var tvRating = findViewById<TextView>(R.id.tvRating)

        rbEjemplo.rating = 2.5f
        rbEjemplo.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            tvRating.text = "${rating}/${ratingBar.numStars}"
        }*/


        var pbDeterminado = findViewById<ProgressBar>(R.id.pbDeterminado)
        var pbSecundario = findViewById<ProgressBar>(R.id.pbSecundario)
        pbDeterminado.max = 200
        pbDeterminado.progress = 0
        pbSecundario.progress = 0
        pbSecundario.secondaryProgress = 0


        var sbNormal = findViewById<SeekBar>(R.id.sbNormal)
        sbNormal.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser)
                    Toast.makeText(activityContext, "Tú lo cambiaste", Toast.LENGTH_SHORT).show()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        /*
        PARA USAR GlobalScope Y USAR LA CORRUTINAS HAY QUE AÑADIR EN EL GRADLE LA SIGUIENTE LINEA
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
        */
        /*GlobalScope.launch {
            progressManager(pbDeterminado)
            progressManager(pbSecundario)
            seekbarManager(sbNormal)
        }*/
    }

    private fun seekbarManager(sb: SeekBar){
        while (true){
            sleep(100L)
            sb.incrementProgressBy(5)
        }
    }

    private fun progressManager(pb: ProgressBar){
        while (pb.progress < pb.max){
            sleep(100L)
            //pb.progress += 5
            pb.incrementProgressBy(5)
            if (pb.id == R.id.pbSecundario) pb.incrementSecondaryProgressBy(10)
        }
    }
}