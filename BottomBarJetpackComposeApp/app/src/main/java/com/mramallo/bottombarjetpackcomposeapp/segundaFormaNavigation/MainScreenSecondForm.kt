package com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.components.BottomNavigationBar
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.navigation.Destinations
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.navigation.NavigationHost

@Composable
fun MainScreenSecondForm() {
    val navController = rememberNavController()
    
    val navigationItems = listOf(
        Destinations.FirstScreen,
        Destinations.SecondScreen,
        Destinations.ThirdScreen
    )
    
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, items = navigationItems)
        }
    ) {
        NavigationHost(navController = navController)
    }
}

