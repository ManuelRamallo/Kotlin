package com.mramallo.bottombarjetpackcomposeapp.segundaFormaNavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FirstScreen(){
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green),
        contentAlignment = Alignment.Center,

    ){
        Text(text = "FirstScreen", color = Color.White,
        fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h3.fontSize
        )
    }
}

@Composable
@Preview
fun FirstScreenPreview(){
    FirstScreen()
}