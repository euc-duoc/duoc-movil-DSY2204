package com.example.prueba

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PrincipalScreen(
    nombre: String,
    modifier: Modifier,
    navigateToSecundaria: (String) -> Unit
) {
    var dato by remember { mutableStateOf("") }
    var errorVacio by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Esta es la página '$nombre'",
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ingrese nombre de screen secundaria:",
            modifier = modifier
        )

        if(errorVacio) {
            Text(
                text = "Debe ingresar un texto",
                color = Color.Red,
                modifier = modifier
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = dato, onValueChange = { dato = it })

        Button (onClick = {
            if(dato == "")
                errorVacio = true;
            else
                navigateToSecundaria(dato)
        }) {
            Text(text = "Ir a secundaria")
        }
    }
}