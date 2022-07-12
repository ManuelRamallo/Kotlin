package com.mramallo.jetpackcomposenavigation.navigation


/**
 * Con esto lo que se consigue es tipar y limitar las pantallas
 * de nuestra app, para en el momento que queramos hacer navegaciones unicamente,
 * entender que podemos navegar unicamente a las pantallas que tenemos aquí,
 * asi nos aseguramos de indicar que las pantallas solo son estas*/
sealed class AppScreens(val route: String) {
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")

}
