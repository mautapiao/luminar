package cl.duocuc.lumina2.ui.screens.lumina

import PantallaIndicador
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cl.duocuc.lumina2.data.local.ChileIndicators

@Composable
fun UtmScreen(navController: NavHostController,indicator: ChileIndicators) {
    PantallaIndicador(
        titulo = "UTM",
        valor = indicator.utm,
        descripcion = "Unidad Tributaria Mensual",
        color = Color(0xFF9C27B0),
        onBack = { navController.popBackStack() }
    )
}

// preview
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun UtmScreenPreview() {
    // Datos simulados para el preview
    val mockIndicator = ChileIndicators(
        date="2025-8-25",
        utm = "$66.778",
        uf = "$37.248,52",
        dolar = "$948,50",
        ipc = "2,1%"

    )

    UtmScreen(
        navController = rememberNavController(), // NavController simulado
        indicator = mockIndicator
    )
}