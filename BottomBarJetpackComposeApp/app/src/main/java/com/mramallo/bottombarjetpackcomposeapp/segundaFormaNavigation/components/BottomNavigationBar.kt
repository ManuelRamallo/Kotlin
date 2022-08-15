package com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.components

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.navigation.Destinations

@Composable
fun BottomNavigationBar(navController: NavHostController, items: List<Destinations>) {

    val currentRoute = currentRoute(navController = navController)

    BottomNavigation {
        items.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route) {
                    // Cada vez que navegemos a un elemento distinto dentro de nuestra barra de navegacion
                    // va a eliminar nuestra pila de navegacion o backstack para que no se vaya creando una pila muy grande
                    // y simplemente cuando presionen el botón de atrás nos saque de la app
                    popUpTo(navController.graph.findStartDestination().id){
                        saveState = true
                    }

                    // esta opcion lo que nos permite es que si el usuario está presionando de forma continua un mismo elemento de nuestra barra de navegacion
                    // no se va a estar creando una pila de navegacion mas extensa
                    launchSingleTop = true
                } },
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                alwaysShowLabel = true
                )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navStackEntry by navController.currentBackStackEntryAsState()
    return navStackEntry?.destination?.route
}