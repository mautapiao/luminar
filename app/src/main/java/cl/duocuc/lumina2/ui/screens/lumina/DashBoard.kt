package cl.duocuc.lumina2.ui.screens.lumina

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cl.duocuc.lumina2.data.BotonMenuData
import cl.duocuc.lumina2.data.fake.FakeWeatherProvider
import cl.duocuc.lumina2.utils.getCurrentDate

// en JetPack Compose, el equivalente de una view es un Composable (@composable)
@Composable
fun DashboardScreen(
    navController: NavHostController, // recibe el navController como parametro
    onBack: () -> Unit
) {
    // listOf(botones) son datos de configuración dara/BotonMenuData
    val botones = BotonMenuData.botones
    /**
     * Scaffold es un componente de Jetpack Compose que proporciona la estructura
     * básica de una pantalla Material Design.
     * Descripción: Define el layout principal de la pantalla con slots para
     * elementos comunes como barra superior, barra inferior, botón flotante
     * y contenido principal, aplicando automáticamente el padding apropiado
     * entre componentes.
     **/

    Scaffold(
        // topBar es un parámetro slot del Scaffold que define la barra superior de la pantalla.
        topBar = { SimpleTopBar(title = "Cerrar", showBack = true, onBack = onBack) }
    ) {

        // padding es un parámetro lambda que recibe los valores de padding calculados
        // automáticamente por el Scaffold.
        // Contiene las dimensiones de espaciado (top, bottom, start, end)
        // que el Scaffold genera para evitar que el contenido se superponga con elementos
        // como la topBar, bottomBar

            padding ->

        // Fondo casi negro
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212)) // Fondo casi negro
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)

        ) {
            // Espacio entre elementos
            Spacer(modifier = Modifier.height(70.dp))

            // fecha actual utils getCurrentDate()
            Text(
                text = getCurrentDate().uppercase(),
                fontSize = 25.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // Grid de botones 2x2
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Lazy List Item Iteration
                // Es una "función de iteración especializada para Compose"
                // que se comporta como un bucle pero optimizado para UI reactiva.

                // fragment, view y viewGroups

                items(botones) { boton ->

                    // Usa botonCard.kt

                    BotonCardFragmentViewGroup(
                        item = boton,

                        // el onClick está configurado para navegar a una ruta de destino.
                        onClick = {
                            navController.navigate(boton.destino)
                        }
                    )

                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {

    val navController = rememberNavController()

    DashboardScreen(
        navController = navController,
        onBack = { }
    )
}