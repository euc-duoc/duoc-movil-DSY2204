package com.example.prueba

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SecundariaScreen(
    dato: String,
    modifier: Modifier,
    navigateToPrincipal: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Esta es la página '$dato'",
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button (onClick = { navigateToPrincipal() }) {
            Text(text = "Ir a principal")
        }
    }
}