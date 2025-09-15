package cl.duocuc.lumina2.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.ui.graphics.Color
import cl.duocuc.lumina2.utils.BotonItem

object BotonMenuData {
    /**
     * listOf
     * Crea una lista inmutable (solo lectura)
     * Características:
     *
     * Inmutable: No se puede modificar después de creada
     * Indexada: Acceso por índice lista[0]
     * Ordenada: Mantiene el orden de inserción
     * Permite duplicados
     **/

    val botones = listOf(
        BotonItem(
            icono = Icons.Default.Paid, // icono
            titulo = "UF", // titulo indicador
            descripcion = "Unidad de Fomento", // descripción del indicador
            color = Color(0xFF4CAF50), // color Verde
            destino = "indicador/uf" // ruta con parametro (ej uf)
        ),
        BotonItem(
            icono = Icons.Default.TrendingUp,
            titulo = "IPC",
            descripcion = "Índice Precios",
            color = Color(0xFF2196F3), // Azul
            destino = "indicador/ipc"
        ),
        BotonItem(
            icono = Icons.Default.AccountBalance,
            titulo = "UTM",
            descripcion = "Unidad Tributaria",
            color = Color(0xFF9C27B0), // Morado
            destino = "indicador/utm"
        ),
        BotonItem(
            icono = Icons.Default.CurrencyExchange,
            titulo = "DÓLAR",
            descripcion = "Valor del Dólar",
            color = Color(0xFF0B1D13), // Naranja
            destino = "indicador/dolar"
        ),
        BotonItem(
            icono = Icons.Default.Calculate,
            titulo = "CALC",
            descripcion = "Calculadora",
            color = Color(0xFF0D1B2A), // azul
            destino = "calc"

        ),
        BotonItem(
            icono = Icons.Default.Analytics,
            titulo = "ANÁLISIS",
            descripcion = "Estadísticas...",
            color = Color(0xFF2E5339), // azul
            destino = "analisis"

        ),
        BotonItem(
            icono = Icons.Default.Password,
            titulo = "PASS",
            descripcion = "Acerca de...",
            color = Color(0xFF2E5339), // azul
            destino = "info"

        )
    )

}