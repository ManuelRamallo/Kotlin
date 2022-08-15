package com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.screens.FirstScreen
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.screens.SecondScreen
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.screens.ThirdScreen

@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Destinations.FirstScreen.route ) {
        /*composable(route = Destinations.FirstScreen.route) {
            FirstScreen(
                navigationSecondScreen = { newText ->
                    navController.navigate(Destinations.SecondScreen.createRoute(newText))
                }
            )
        }*/
        /*composable(route = Destinations.SecondScreen.route, arguments = listOf(navArgument("newText"){defaultValue = "Screen 2"})
        ) { navBackStackEntry ->
            var newText = navBackStackEntry.arguments?.getString("newText")
            requireNotNull(newText)
            SecondScreen(newText)
        }*/

        // TODO - Lo de arriba ya lo terminaré

        composable(route = Destinations.FirstScreen.route) {
            FirstScreen()
        }

        composable(route = Destinations.SecondScreen.route) {
            SecondScreen("Navigation Host")
        }

        composable(route = Destinations.ThirdScreen.route) {
            ThirdScreen()
        }
    }


}