package com.israelbrea.jetpackcomposecatalogocomponentes

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.israelbrea.jetpackcomposecatalogocomponentes.ui.theme.JetpackComposeCatalogoComponentesTheme

//--------------------------------------------------------------------------------------------------

// LAYOUTS

//--------------------------------------------------------------------------------------------------
//Box - FrameLayout

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text("Esto es un ejemplo")
        }
    }
}

//--------------------------------------------------------------------------------------------------

// Column - LinearLayout(Vertical)

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Red)
                .height(100.dp)
        )
        Text(
            "Ejemplo2", modifier = Modifier
                .background(Color.Cyan)
                .height(100.dp)
        )
        Text(
            "Ejemplo3", modifier = Modifier
                .background(Color.Blue)
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo5", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo6", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo7", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo8", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo9", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo10", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo11", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo12", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo13", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo14", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
        Text(
            "Ejemplo15", modifier = Modifier
                .background(Color.Magenta)
                .height(100.dp)
        )
    }
}

//--------------------------------------------------------------------------------------------------

// Row - LinearLayout(Horizontal)

@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Red)
                .width(100.dp)
        )
        Text(
            "Ejemplo2", modifier = Modifier
                .background(Color.Cyan)
                .width(100.dp)
        )
        Text(
            "Ejemplo3", modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
        )
        Text(
            "Ejemplo3", modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
        )
        Text(
            "Ejemplo3", modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
        )
    }
}

//--------------------------------------------------------------------------------------------------

// Combinación de Layouts

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan)
        ) {

        }
        Row(
            Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Soy Israel Brea Piñero")
            }
        }
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan)
        ) {

        }
    }
}

//--------------------------------------------------------------------------------------------------

// Reto - Combinación de Layouts

@Composable
fun RetoComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        Row(
            Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutsPreview() {
    JetpackComposeCatalogoComponentesTheme {
        RetoComplexLayout()
    }
}