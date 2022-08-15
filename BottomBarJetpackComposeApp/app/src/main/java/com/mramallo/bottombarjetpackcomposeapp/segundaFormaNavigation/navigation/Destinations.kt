package com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(val route: String, val title: String, val icon: ImageVector) {

    object FirstScreen: Destinations("firstScreen", title = "FirstScreen", icon = Icons.Filled.Home)
    object SecondScreen: Destinations("secondScreen/?newText={newText}", title = "SecondScreen", icon = Icons.Filled.Settings){
        fun createRoute(newText: String) = "secondScreen/?newText=$newText"
    }
    object ThirdScreen: Destinations("thirdScreen", title = "ThirdScreen", icon = Icons.Filled.Favorite)

}