package cl.duocuc.lumina2.data.repository

import cl.duocuc.lumina2.data.model.ChileIndicators
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.math.BigDecimal

object IndicatorRepository {
    // datos mock si se usa entidad pasar a repo

    val indicators = listOf(
        ChileIndicators(
            date = "2025-09-11",
            uf = BigDecimal("37945.23"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.31"),
            dolar = BigDecimal("925.75")
        ),
        ChileIndicators(
            date = "2025-09-12",
            uf = BigDecimal("37946.85"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.31"),
            dolar = BigDecimal("927.20")
        ),
        ChileIndicators(
            date = "2025-09-13",
            uf = BigDecimal("37948.47"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.32"),
            dolar = BigDecimal("928.90")
        ),
        ChileIndicators(
            date = "2025-09-14",
            uf = BigDecimal("37950.09"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.32"),
            dolar = BigDecimal("930.15")
        ),
        ChileIndicators(
            date = "2025-09-15",
            uf = BigDecimal("37951.71"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.32"),
            dolar = BigDecimal("931.80")
        ),
        ChileIndicators(
            date = "2025-09-16",
            uf = BigDecimal("37953.33"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.33"),
            dolar = BigDecimal("929.45")
        ),
        ChileIndicators(
            date = "2025-09-17",
            uf = BigDecimal("37954.95"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.33"),
            dolar = BigDecimal("928.70")
        ),
        ChileIndicators(
            date = "2025-09-18",
            uf = BigDecimal("37956.57"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.33"),
            dolar = BigDecimal("933.25")
        ),
        ChileIndicators(
            date = "2025-09-19",
            uf = BigDecimal("37958.19"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.34"),
            dolar = BigDecimal("935.60")
        ),
        ChileIndicators(
            date = "2025-09-20",
            uf = BigDecimal("37959.81"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.34"),
            dolar = BigDecimal("937.15")
        ),
        ChileIndicators(
            date = "2025-09-21",
            uf = BigDecimal("37961.43"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.34"),
            dolar = BigDecimal("934.80")
        ),
        ChileIndicators(
            date = "2025-09-22",
            uf = BigDecimal("37963.05"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.35"),
            dolar = BigDecimal("932.40")
        ),
        ChileIndicators(
            date = "2025-09-23",
            uf = BigDecimal("37964.67"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.35"),
            dolar = BigDecimal("931.95")
        ),
        ChileIndicators(
            date = "2025-09-24",
            uf = BigDecimal("37966.29"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.35"),
            dolar = BigDecimal("929.75")
        ),
        ChileIndicators(
            date = "2025-09-25",
            uf = BigDecimal("37967.91"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.36"),
            dolar = BigDecimal("928.30")
        ),
        ChileIndicators(
            date = "2025-09-26",
            uf = BigDecimal("37969.53"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.36"),
            dolar = BigDecimal("926.85")
        ),
        ChileIndicators(
            date = "2025-09-27",
            uf = BigDecimal("37971.15"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.36"),
            dolar = BigDecimal("930.20")
        ),
        ChileIndicators(
            date = "2025-09-28",
            uf = BigDecimal("37972.77"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.37"),
            dolar = BigDecimal("932.75")
        ),
        ChileIndicators(
            date = "2025-09-29",
            uf = BigDecimal("37974.39"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.37"),
            dolar = BigDecimal("935.10")
        ),
        ChileIndicators(
            date = "2025-09-30",
            uf = BigDecimal("37976.01"),
            utm = BigDecimal("63452.00"),
            ipc = BigDecimal("0.37"),
            dolar = BigDecimal("938.45")
        )
    )

    // Buscar el dato por la fecha de hoy
    fun getTodayIndicator(): ChileIndicators? {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return indicators.find { it.date == today }
    }
    // Devuelve la fecha del último registro cargado en la lista como referwencia
    fun getLastUpdate(): String {
        return indicators.last().date
    }
}