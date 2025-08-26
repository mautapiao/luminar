package cl.duocuc.lumina2.ui.screens.lumina

import BotonItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cl.duocuc.lumina2.utils.getCurrentDate

@Composable
fun DashboardScreen(
    navController: NavHostController, // recibe el navController como parametro
    onBack: () -> Unit
) {

    val botones = listOf(
        BotonItem(
            icono = Icons.Default.Paid,
            titulo = "UF",
            fecha = "Unidad de Fomento",
            color = Color(0xFF4CAF50), // Verde
            destino = "uf"
        ),
        BotonItem(
            icono = Icons.Default.TrendingUp,
            titulo = "IPC",
            fecha = "Índice Precios",
            color = Color(0xFF2196F3), // Azul
            destino = "ipc"
        ),
        BotonItem(
            icono = Icons.Default.AccountBalance,
            titulo = "UTM",
            fecha = "Unidad Tributaria",
            color = Color(0xFF9C27B0), // Morado
            destino = "utm"
        ),
        BotonItem(
            icono = Icons.Default.CurrencyExchange,
            titulo = "Dólar",
            fecha = "Valor del Dólar",
            color = Color(0xFFFF9800), // Naranja
            destino = "dolar"
        )
    )

    Scaffold(
        topBar = { SimpleTopBar(title = "Cerrar", showBack = true, onBack = onBack) }
    ) { padding ->

        // Fondo casi negro
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212)) // Fondo casi negro
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // espacio entre elementos
            Spacer(modifier = Modifier.height(85.dp))

            // Título
            Text(
                text = "Indicadores Económicos",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // fecha actual utils getCurrentDate()
            Text(
                text = getCurrentDate(),
                fontSize = 26.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // espacio entre elementos
            Spacer(modifier = Modifier.height(20.dp))

            // Grid de botones 2x2
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(botones) { boton ->
                    // usa botonCard.kt
                    BotonCard(
                        item = boton,
                        onClick = {
                            navController.navigate(boton.destino)
                        }
                    )
                }
            }

            // espacio entre elementos
            Spacer(modifier = Modifier.weight(1f))

            // Texto de ayuda para accesibilidad
            Text(
                text = "Toca cualquier botón para ver los valores actualizados",
                fontSize = 26.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
    }
}
