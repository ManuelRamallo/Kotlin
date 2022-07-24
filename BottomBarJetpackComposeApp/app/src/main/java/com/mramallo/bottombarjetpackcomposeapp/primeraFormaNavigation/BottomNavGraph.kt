package com.mramallo.bottombarjetpackcomposeapp.primeraFormaNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mramallo.bottombarjetpackcomposeapp.primeraFormaNavigation.screens.HomeScreen
import com.mramallo.bottombarjetpackcomposeapp.primeraFormaNavigation.screens.NewsScreen
import com.mramallo.bottombarjetpackcomposeapp.primeraFormaNavigation.screens.ProfileScreen
import com.mramallo.bottombarjetpackcomposeapp.primeraFormaNavigation.screens.SettingsScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) { HomeScreen() }
        composable(route = BottomBarScreen.Profile.route) { ProfileScreen() }
        composable(route = BottomBarScreen.Settings.route) { SettingsScreen() }
        composable(route = BottomBarScreen.News.route) { NewsScreen() }
    }
}