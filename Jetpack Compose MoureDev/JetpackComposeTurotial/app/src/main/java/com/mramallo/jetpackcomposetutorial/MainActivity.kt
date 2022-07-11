package com.mramallo.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import com.mramallo.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import kotlin.math.exp


private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
    MyMessage("Hola Jetpack Compose 2", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi."),
    MyMessage("Hola Jetpack Compose 3", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi. Nunc et finibus felis, in molestie magna. Pellentesque viverra porttitor pretium. In auctor in justo et fringilla. Aliquam a sollicitudin neque. Fusce semper nisl et finibus mollis. Nunc id condimentum diam. Nullam dignissim tempus scelerisque."),
    MyMessage("Hola Jetpack Compose 4", "Preparado? Lorem ipsum dolor sit amet,"),
    MyMessage("Hola Jetpack Compose 5", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi. Nunc et finibus felis, in molestie magna. Pellentesque viverra porttitor pretium. In auctor in justo et fringilla. Aliquam a sollicitudin neque. Fusce semper nisl et finibus mollis. Nunc id condimentum diam. Nullam dignissim tempus scelerisque."),
    MyMessage("Hola Jetpack Compose 6", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
    MyMessage("Hola Jetpack Compose 7", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
    MyMessage("Hola Jetpack Compose 8", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi."),
    MyMessage("Hola Jetpack Compose 9", "Preparado? Lorem ipsum dolor sit amet,"),
    MyMessage("Hola Jetpack Compose 10", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi. Nunc et finibus felis, in molestie magna. Pellentesque viverra porttitor pretium. In auctor in justo et fringilla. Aliquam a sollicitudin neque. Fusce semper nisl et finibus mollis. Nunc id condimentum diam. Nullam dignissim tempus scelerisque."),
    MyMessage("Hola Jetpack Compose 11", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
    MyMessage("Hola Jetpack Compose 12", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi."),
    MyMessage("Hola Jetpack Compose 13", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
    MyMessage("Hola Jetpack Compose 14", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi. Nunc et finibus felis, in molestie magna. Pellentesque viverra porttitor pretium. In auctor in justo et fringilla. Aliquam a sollicitudin neque. Fusce semper nisl et finibus mollis. Nunc id condimentum diam. Nullam dignissim tempus scelerisque."),
    MyMessage("Hola Jetpack Compose 15", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi."),
    MyMessage("Hola Jetpack Compose 16", "Preparado? Lorem ipsum dolor sit amet,"),
    MyMessage("Hola Jetpack Compose 17", "Preparado? Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultrices pellentesque hendrerit. Morbi semper, mauris ac consequat tempus, metus enim fermentum purus, vitae dapibus eros metus vitae leo. Nulla facilisi."),

)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme( ) {
                myMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun myMessages(messages: List<MyMessage>) {
    LazyColumn { // Con esto solo se renderiza los elementos que están en pantalla
        items(messages) {
            myComponents(message = it)
        }
    }
}


@Composable
fun myComponents(message: MyMessage){
    Row(
        Modifier
            .fillMaxWidth() // Esto es para que coja todoo el ancho
            .background(MaterialTheme.colors.background)
            .padding(8.dp)) {
        myImage()
        myTexts(message)
    }
}

@Composable
fun myImage() {
    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Mi imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
    )
}

@Composable
fun myTexts(message: MyMessage) {

    /** Se puede usar esta sintaxis para almacenar y modificar
     * valores en tiempo de ejecución dentro de interfaces visuales
     * de jetpaclk compose*/
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        Modifier
            .padding(start = 8.dp)
            .clickable {
                isExpanded = !isExpanded
            }) {
        myText(message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1)

        Spacer(modifier = Modifier.height(16.dp))

        myText(message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2,
            lines = if(isExpanded) Int.MAX_VALUE  else 1 )
    }
}

@Composable
fun myText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
}

/**
 * Podemos tener varios previews para poder verlo como por ejemplo ahora
 * en los dos modos, oscuro o claro*/

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES) // Con esto podemos verlo en modo oscuro
@Composable
fun previewComponents(){
    JetpackComposeTutorialTheme {
        myMessages(messages)
    }
}