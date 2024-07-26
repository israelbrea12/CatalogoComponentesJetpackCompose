package com.israelbrea.jetpackcomposecatalogocomponentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyFilledTonalButton(){
    FilledTonalButton(onClick = {  }) {
        Text(text = "IbreapiDevs")
    }
}

@Preview
@Composable
fun MyElevatedButton(){
    ElevatedButton(onClick = {  }) {
        Text(text = "IbreapiDevs")
    }
}

@Preview
@Composable
fun MyFloatingActionButton(){
    FloatingActionButton(onClick = {  }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Floating action button")
    }
}

@Preview
@Composable
fun MySmallFloatingActionButton(){
    SmallFloatingActionButton(onClick = {  }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Floating action button")
    }
}

@Preview
@Composable
fun MyLargeFloatingActionButton(){
    LargeFloatingActionButton(onClick = {  }) {
        Icon(Icons.Filled.Favorite, contentDescription = "Floating action button")
    }
}

@Preview
@Composable
fun MyExtendedFloatingActionButton(){
    ExtendedFloatingActionButton(onClick = { print("Hello") },
        text = { Text(text = "Extended FAB") },
        icon = { Icon(Icons.Filled.Favorite, contentDescription = "Floating action button") } )
}

