package com.mramallo.bottombarjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mramallo.bottombarjetpackcomposeapp.primeraFormaNavigation.MainScreen
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.MainScreenSecondForm
import com.mramallo.bottombarjetpackcomposeapp.ui.theme.BottomBarJetpackComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomBarJetpackComposeAppTheme {
                //MainScreen() // esto es para la primera forma de navegacion
                MainScreenSecondForm() // esto es para la segunda forma de navegación
            }
        }
    }
}