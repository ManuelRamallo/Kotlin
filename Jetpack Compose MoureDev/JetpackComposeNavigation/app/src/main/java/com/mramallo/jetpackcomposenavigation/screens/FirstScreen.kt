package com.mramallo.jetpackcomposenavigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mramallo.jetpackcomposenavigation.navigation.AppScreens

@Composable
fun FirstScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "First Screen")
            }
        }
    ) {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Vamos a ver la navegacion")
        Button(onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route + "/Este es un parámetro")
        }) {
            Text(text = "Navegar")
        }
    }
}
