package cl.duocuc.lumina2.ui.screens.lumina

import PantallaIndicador
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cl.duocuc.lumina2.data.local.ChileIndicators

// Pantallas de destino, cuando sea una base de datos refactorizar estas composable
@Composable
fun UfScreen(navController: NavHostController, indicator: ChileIndicators) {
    PantallaIndicador(
        titulo = "UF",
        valor = indicator.uf,
        descripcion = "Unidad de Fomento",
        color = Color(0xFF4CAF50),
        onBack = { navController.popBackStack() }
    )
}

// preview
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun UfScreenPreview() {
    // Datos simulados para el preview
    val mockIndicator = ChileIndicators(
        date="2025-8-25",
        utm = "$66.778",
        uf = "$37.248,52",
        dolar = "$948,50",
        ipc = "2,1%"

    )

    UfScreen(
        navController = rememberNavController(), // NavController simulado
        indicator = mockIndicator
    )
}