package com.israelbrea.jetpackcomposecatalogocomponentes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SensorDoor
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

//--------------------------------------------------------------------------------------------------

// Animación de color básica

@Composable
fun ColorAnimationSimple() {

    var firstColor by remember {
        mutableStateOf(false)
    }

    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        label = ""
    )

    Box(modifier = Modifier
        .size(100.dp)
        .background(realColor)
        .clickable { firstColor = !firstColor })

}

//--------------------------------------------------------------------------------------------------

// Animación de color avanzada

@Composable
fun ColorAnimationAvanzada() {

    var firstColor by remember {
        mutableStateOf(false)
    }

    var showBox by remember {
        mutableStateOf(true)
    }

    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        label = "",
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )

    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })
    }
}

//--------------------------------------------------------------------------------------------------

// Animación de tamaño básica

@Composable
fun SizeAnimation() {

    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }

    val size by animateDpAsState(targetValue = if (smallSize) 50.dp else 100.dp, label = "")

    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize })

}

//--------------------------------------------------------------------------------------------------

// Animación de tamaño avanzada

@Composable
fun SizeAnimationAvanzada() {

    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }

    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        label = "",
        animationSpec = tween(durationMillis = 500),
        finishedListener = { if(!smallSize){} }
    )

    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize })

}

//--------------------------------------------------------------------------------------------------

// Animación de visibilidad básica

@Composable
fun VisibilityAnimation() {

    var isVisible by remember {
        mutableStateOf(true)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar/Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility (isVisible, enter = slideInHorizontally(), exit = slideOutHorizontally()) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

//--------------------------------------------------------------------------------------------------

// Crossfade

@Composable
fun CrossfadeAnimation() {
    var myComponentType:ComponentType by remember {
        mutableStateOf(ComponentType.Text)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(targetState = myComponentType, label = "") {
            when(it){
                ComponentType.Image -> Icon(Icons.Default.SensorDoor, contentDescription = "")
                ComponentType.Text -> Text(text = "SOY UN COMPONENTE")
                ComponentType.Box -> Box(modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red))
                ComponentType.Error -> Text(text = "ERRORRRRR")
            }
        }
    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}

fun getComponentTypeRandom(): ComponentType {
    return when(nextInt(from = 0, until = 3)){
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}