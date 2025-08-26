package cl.duocuc.lumina2.data.local

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FakeIndicators {

    // datos mock si se usa entidad pasar a repo
    val indicators = listOf(
        ChileIndicators(
            date = "2025-08-25",
            uf = "$37.890,45",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$930,50"
        ),
        ChileIndicators(
            date = "2025-08-26",
            uf = "$37.892,10",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$932,00"
        ),
        ChileIndicators(
            "2025-08-27",
            uf = "$37.895,20",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$933,50"
        ),
        ChileIndicators(
            "2025-08-28",
            uf = "$37.898,30",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$934,20"
        ),
        ChileIndicators(
            "2025-08-29",
            uf = "$37.901,40",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$935,00"
        ),
        ChileIndicators(
            "2025-08-30",
            uf = "$37.904,50",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$935,80"
        ),
        ChileIndicators(
            "2025-08-31",
            uf = "$37.907,60",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$936,40"
        ),
        ChileIndicators(
            "2025-09-01",
            uf = "$37.910,70",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$937,10"
        ),
        ChileIndicators(
            "2025-09-02",
            uf = "$37.913,80",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$938,00"
        ),
        ChileIndicators(
            "2025-09-03",
            uf = "$37.916,90",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$939,20"
        ),
        ChileIndicators(
            "2025-09-04",
            uf = "$37.920,00",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$940,50"
        ),
        ChileIndicators(
            "2025-09-05",
            uf = "$37.923,10",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$941,00"
        ),
        ChileIndicators(
            "2025-09-06",
            uf = "$37.926,20",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$941,50"
        ),
        ChileIndicators(
            "2025-09-07",
            uf = "$37.929,30",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$942,10"
        ),
        ChileIndicators(
            "2025-09-08",
            uf = "$37.932,40",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$942,80"
        ),
        ChileIndicators(
            "2025-09-09",
            uf = "$37.935,50",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$943,30"
        ),
        ChileIndicators(
            "2025-09-10",
            uf = "$37.938,60",
            utm = "$63.452,00",
            ipc = "0.3%",
            dolar = "$944,00"
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
