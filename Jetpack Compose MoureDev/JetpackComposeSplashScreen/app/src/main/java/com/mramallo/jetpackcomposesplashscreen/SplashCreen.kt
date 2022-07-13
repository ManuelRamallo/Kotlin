package com.mramallo.jetpackcomposesplashscreen.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mramallo.jetpackcomposesplashscreen.R
import kotlinx.coroutines.delay

@Composable
fun SplashCreen(navController: NavHostController) {
    
    LaunchedEffect(key1 =  true) {
        delay(5000)
        navController.popBackStack()
        navController.navigate(AppScreens.MainScreen.route)
    }


    Splash()
}

@Composable
fun Splash() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo icon",
            modifier = Modifier.size(150.dp, 150.dp)
        )
        Text(
            text = "Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }


}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}