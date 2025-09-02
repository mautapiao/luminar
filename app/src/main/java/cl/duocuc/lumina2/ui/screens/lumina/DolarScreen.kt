package cl.duocuc.lumina2.ui.screens.lumina

import PantallaIndicador
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cl.duocuc.lumina2.data.local.ChileIndicators


@Composable
fun DolarScreen(navController: NavHostController, indicator: ChileIndicators) {
    PantallaIndicador(
        titulo = "Dólar",
        valor = indicator.dolar,
        descripcion = "Dólar Observado",
        color = Color(0xFF0B1D13),
        onBack = { navController.popBackStack() }
    )
}

// preview
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun DolarScreenPreview() {
    // Datos simulados para el preview
    val mockIndicator = ChileIndicators(
        date="2025-8-25",
        utm = "$66.778",
        uf = "$37.248,52",
        dolar = "$948,50",
        ipc = "2,1%"

    )

    DolarScreen(
        navController = rememberNavController(), // NavController simulado
        indicator = mockIndicator
    )
}
