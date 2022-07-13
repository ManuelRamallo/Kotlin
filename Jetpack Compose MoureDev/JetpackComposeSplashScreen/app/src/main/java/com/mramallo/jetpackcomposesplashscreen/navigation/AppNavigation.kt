package com.mramallo.jetpackcomposesplashscreen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route){
            SplashCreen(navController)
        }

        composable(AppScreens.MainScreen.route) {
            MainScreen()
        }
    }
}