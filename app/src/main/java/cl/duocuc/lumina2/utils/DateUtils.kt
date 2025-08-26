package cl.duocuc.lumina2.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Función para obtener fecha actual
fun getCurrentDate(): String {
    val formatter = SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy", Locale("es", "ES"))
    return formatter.format(Date())
}

// Para comparar con la lista formato (yyyy-MM-dd)
fun getTodayKey(): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return formatter.format(Date())
}

