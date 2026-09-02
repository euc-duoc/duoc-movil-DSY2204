package com.example.prueba.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.prueba.PrincipalScreen
import com.example.prueba.SecundariaScreen
import com.example.prueba.UsuariosScreen

@Composable
fun NavigationWrapper(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Principal)  {
        composable<Principal> {
            PrincipalScreen(
                nombre = "Principal",
                modifier = modifier,
                navigateToSecundaria = { dato -> navController.navigate(Secundaria(dato = dato)) },
                navigateToUsuarios = { navController.navigate(Usuarios) }
            )
        }

        composable<Secundaria> {
            val detalle = it.toRoute<Secundaria>()

            SecundariaScreen(detalle.dato, modifier) {
                navController.navigate(Principal)
            }
        }

        composable<Usuarios> {
            UsuariosScreen(modifier)
        }
    }
}