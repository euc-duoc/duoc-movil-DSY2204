package com.example.prueba

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Usuario(
    val rut: String,
    val nombre: String
)

class UsuarioRepository {
    // The companion object acts as the 'static' container
    companion object {
        val usuarios: List<Usuario> = listOf(
            Usuario("123456", "Enrique"),
            Usuario("654321", "Hola")
        )
    }
}

@Composable
fun ListaUsuarios(
    modifier: Modifier,
    usuarios: List<Usuario>
) {
    LazyColumn (
        modifier = modifier,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(
            items = usuarios,
            key = { us -> us.rut }
        ) { us ->
            ItemUsuario(us = us, modifier)
        }
    }
}

@Composable
fun ItemUsuario(us: Usuario, modifier: Modifier) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = us.rut,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "By ${us.nombre}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}