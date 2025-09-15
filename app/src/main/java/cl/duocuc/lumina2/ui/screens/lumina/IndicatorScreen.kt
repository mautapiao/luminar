package cl.duocuc.lumina2.ui.screens.lumina

import PantallaIndicador
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cl.duocuc.lumina2.data.model.IndicatorConfig
import cl.duocuc.lumina2.data.repository.IndicatorRepository
import java.math.BigDecimal

// Pantallas de destino, cuando sea una base de datos refactorizar estas composable
@Composable
fun IndicatorScreen(navController: NavHostController, indicator: String) {

    // indicador del día
    val todayIndicator = IndicatorRepository.getTodayIndicator()

    /**
     *
     * Uso de when: es más versatil comparado con switch de java (pág.22)
     *
     * Ejemplo:
     *
     * fun archenemy( heroName: String) = when (heroName){
     *          "Batman" -> "Joker"
     *          "Superman" -> "Lex Luthor"
     *          "Spider Man" -> "Green Goblin"
     *          else -> "Sorry, no idea"
     *       }
     *  En el ejemplo anterior else sirve como un fallback
     *
     *  Metodo Factory: es un patron de diseño para la creación de objetos. (pág: 51 y 52)
     *
     *  El when está actuando como una fábrica de objetos que crea diferentes instancias
     *  de IndicatorConfig basándose en una condición
     *
     *  Ref: Kotlin Design Pattern and Best Practices - Alexy Soshin <packt>
     *
     */

    val config = when(indicator.lowercase()) {
        "uf" -> IndicatorConfig(
            titulo = "UF",
            valor = todayIndicator?.uf ?: BigDecimal.ZERO,
            descripcion = "Unidad de Fomento",
            color = Color(0xFF4CAF50)
        )
        "utm" -> IndicatorConfig(
            titulo = "UTM",
            valor = todayIndicator?.utm ?: BigDecimal.ZERO,
            descripcion = "Unidad Tributaria",
            color = Color(0xFF9C27B0), // Morado
        )
        "ipc" -> IndicatorConfig(
                titulo = "IPC",
                valor = todayIndicator?.ipc ?: BigDecimal.ZERO,
                descripcion = "Indice de Precios",
                color = Color(0xFF2196F3), // Azul
            )
        "dolar" -> IndicatorConfig(
            titulo = "UTM",
            valor = todayIndicator?.dolar ?: BigDecimal.ZERO,
            descripcion = "Valor del Dólar",
            color = Color(0xFF0B1D13), // Azul
        )

        else -> IndicatorConfig(
            titulo = "Sin Información",
            valor =  BigDecimal.ZERO,
            descripcion = "Indicadores",
            color = Color(0xFF4CAF50)
        )
    }

    PantallaIndicador(
        titulo = config.titulo,
        valor = config.valor,
        descripcion = config.descripcion,
        color = config.color,
        onBack = { navController.popBackStack() }
    )
}

// preview
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun IndicatorScreenPreview() {

   IndicatorScreen(
        navController = rememberNavController(), // NavController simulado
        indicator = "uf"
    )
}