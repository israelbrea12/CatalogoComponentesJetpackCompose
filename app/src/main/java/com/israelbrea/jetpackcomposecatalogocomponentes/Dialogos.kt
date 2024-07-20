package com.israelbrea.jetpackcomposecatalogocomponentes

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.israelbrea.jetpackcomposecatalogocomponentes.ui.theme.JetpackComposeCatalogoComponentesTheme

//--------------------------------------------------------------------------------------------------

// AlertDialog

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    if (show) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            title = {
                Text(text = "Documentación  de AlertDialog")
            },
            text = {
                Text(
                    "Descripción de la alerta de ejemplo de material 3."
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm()
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismiss()
                    }
                ) {
                    Text("Salir")
                }
            }
        )
    }
}

//--------------------------------------------------------------------------------------------------

// Dialogo personalizado

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
            }
        }
    }
}

//--------------------------------------------------------------------------------------------------

// Dialogo personalizado avanzado

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {

        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(email = "ejemplo1@gmail.com", drawable = R.drawable.imagen)
                AccountItem(email = "ejemplo2@gmail.com", drawable = R.drawable.imagen2)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.img)
            }
        }
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

//--------------------------------------------------------------------------------------------------

// Dialogo personalizado avanzado

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {

        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                var status by remember {
                    mutableStateOf("")
                }
                MyRadioButtonList(status) { status = it }
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(
                    Modifier
                        .align(Alignment.End)
                        .padding(8.dp)) {
                    TextButton(onClick = { }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = { }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}

//--------------------------------------------------------------------------------------------------

@Preview(showBackground = true)
@Composable
fun DialogPreview() {
    JetpackComposeCatalogoComponentesTheme {
    }
}