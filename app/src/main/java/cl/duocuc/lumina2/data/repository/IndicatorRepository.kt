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

//
//    val indicators = listOf(
//        ChileIndicators(
//            date = "2025-08-25",
//            uf = "$37.890,45",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$930,50"
//        ),
//        ChileIndicators(
//            date = "2025-08-26",
//            uf = "$37.892,10",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$932,00"
//        ),
//        ChileIndicators(
//
//
//
//            "2025-08-27",
//            uf = "$37.895,20",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$933,50"
//        ),
//        ChileIndicators(
//            "2025-08-28",
//            uf = "$37.898,30",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$934,20"
//        ),
//        ChileIndicators(
//            "2025-08-29",
//            uf = "$37.901,40",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$935,00"
//        ),
//        ChileIndicators(
//            "2025-08-30",
//            uf = "$37.904,50",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$935,80"
//        ),
//        ChileIndicators(
//            "2025-08-31",
//            uf = "$37.907,60",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$936,40"
//        ),
//        ChileIndicators(
//            "2025-09-01",
//            uf = "$37.910,70",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$937,10"
//        ),
//        ChileIndicators(
//            "2025-09-02",
//            uf = "$37.913,80",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$938,00"
//        ),
//        ChileIndicators(
//            "2025-09-03",
//            uf = "$37.916,90",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$939,20"
//        ),
//        ChileIndicators(
//            "2025-09-04",
//            uf = "$37.920,00",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$940,50"
//        ),
//        ChileIndicators(
//            "2025-09-05",
//            uf = "$37.923,10",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$941,00"
//        ),
//        ChileIndicators(
//            "2025-09-06",
//            uf = "$37.926,20",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$941,50"
//        ),
//        ChileIndicators(
//            "2025-09-07",
//            uf = "$37.929,30",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$942,10"
//        ),
//        ChileIndicators(
//            "2025-09-08",
//            uf = "$37.932,40",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$942,80"
//        ),
//        ChileIndicators(
//            "2025-09-09",
//            uf = "$37.935,50",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$943,30"
//        ),
//        ChileIndicators(
//            "2025-09-10",
//            uf = "$37.938,60",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$944,00"
//        ),
//        ChileIndicators(
//            "2025-09-11",
//            uf = "$37.941,25",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$947,50"
//        ),
//        ChileIndicators(
//            "2025-09-12",
//            uf = "$37.943,90",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$951,20"
//        ),
//        ChileIndicators(
//            "2025-09-13",
//            uf = "$37.946,55",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$948,80"
//        ),
//        ChileIndicators(
//            "2025-09-14",
//            uf = "$37.949,20",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$952,30"
//        ),
//        ChileIndicators(
//            "2025-09-15",
//            uf = "$37.951,85",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$949,70"
//        ),
//        ChileIndicators(
//            "2025-09-16",
//            uf = "$37.954,50",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$953,10"
//        ),
//        ChileIndicators(
//            "2025-09-17",
//            uf = "$37.957,15",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$956,40"
//        ),
//        ChileIndicators(
//            "2025-09-18",
//            uf = "$37.959,80",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$954,20"
//        ),
//        ChileIndicators(
//            "2025-09-19",
//            uf = "$37.962,45",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$957,80"
//        ),
//        ChileIndicators(
//            "2025-09-20",
//            uf = "$37.965,10",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$959,60"
//        ),
//        ChileIndicators(
//            "2025-09-21",
//            uf = "$37.967,75",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$955,90"
//        ),
//        ChileIndicators(
//            "2025-09-22",
//            uf = "$37.970,40",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$961,20"
//        ),
//        ChileIndicators(
//            "2025-09-23",
//            uf = "$37.973,05",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$958,40"
//        ),
//        ChileIndicators(
//            "2025-09-24",
//            uf = "$37.975,70",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$962,80"
//        ),
//        ChileIndicators(
//            "2025-09-25",
//            uf = "$37.978,35",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$960,10"
//        ),
//        ChileIndicators(
//            "2025-09-26",
//            uf = "$37.981,00",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$964,50"
//        ),
//        ChileIndicators(
//            "2025-09-27",
//            uf = "$37.983,65",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$967,30"
//        ),
//        ChileIndicators(
//            "2025-09-28",
//            uf = "$37.986,30",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$963,70"
//        ),
//        ChileIndicators(
//            "2025-09-29",
//            uf = "$37.988,95",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$968,90"
//        ),
//        ChileIndicators(
//            "2025-09-30",
//            uf = "$37.991,60",
//            utm = "$63.452,00",
//            ipc = "0.3%",
//            dolar = "$965,20"
//        )
//
//    )

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