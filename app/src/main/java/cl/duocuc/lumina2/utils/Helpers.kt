package cl.duocuc.lumina2.utils

import cl.duocuc.lumina2.data.model.ChileIndicators
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

/**
 *
 * Aquí hay algunas funciones que pueden
 * ser utilizadas por diferentes compsables
 * la ides es realizar estas funciones con sentencias
 * propias del lenguaje kotlin
 *
 * Hay dos tipo de funciones:
 *
 * Globales como estas en el helper
 * Locales que viven al interior del composable que no pueden ser llamadas fuera del contexto
 *
 *
 * if-else-if
 * for
 * lisOf
 * println
 *
 * Comentarios en linea y bloque
 *
 * uso de variables var mutable y val inmutable (se usan a lo largo del proyecto)
 *
 */

// Validación: largo del email
fun validateLength(email: String): String {

    // mensaje para Logcat
    println("Validando largo de email helpers");

    return if (email.length < 6) {
        "Largo inválido: muy corto"
    } else if (email.length > 50) {
        "Largo inválido: demasiado largo"
    } else {
        "Resultado Largo válido"
    }
}

// Validación: formato básico
fun validateBasicFormat(email: String): String {
    // mensaje para Logcat
    println("Validando formato básico email helpers");

    return if (email.contains("@") && email.contains(".")) {
        "Resultado válido Formato básico válido"
    } else {
        "Formato inválido (falta @ o .)"
    }
}

// Validación: caracteres prohibidos
fun validateInvalidChars(email: String): String {
    // mensaje para Logcat
    println("Validando carácteres inválidos de email helpers");

    val invalidChars = listOf(" ", ",", ";")
    for (char in invalidChars) {
        if (email.contains(char)) {
            return "Contiene carácter inválido: $char"
        }
    }
    if(email.length == 0){
        return "Ingrese un email"
    }

    return "Resultado Contiene caracteres válidos"
}

// Validación: expresión regular
fun validateRegex(email: String): String {
    val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()

    // mensaje para Logcat
    println("Validando Regex de email helpers");

    return if (regex.matches(email)) {
        "Resultado Regex válido"
    } else {
        "Regex inválido"
    }
}

// Agrupador de todas
fun runAllValidations(email: String): List<String> {

    // mensaje para Logcat
    println("Retorna la validación de email helpers");

    return listOf(
        validateLength(email),
        validateBasicFormat(email),
        validateInvalidChars(email),
        validateRegex(email)
    )
}

fun validarCorreo(correo: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()
}

fun validarPassword(password: String): Boolean {
    return password.length >= 6
}



// Funciones Semana 5

/*
   1. Función de nivel superior
      Es aquella que no está definida dentro de una clase, objeto o interfaz,
      sino directamente en un archivo .kt

      lista: List<ChileIndicators> Recibe una lista de objetos de tipo ChileIndicators.
      map { it.uf.toDouble}: la lista clave valor toma el valor d ela uf que esta como BigDecimal
                        y lo transforma a Double, average indica que debe ser doble
      average: Cálcula el promedio de todos los valores de la lista.

      Resumen: Es aquella que recibe funciones como parámetros o retorna funciones,
               independientemente de dónde esté definida.

 */
fun promedioUF(lista: List<ChileIndicators>): String {

    val promedio = lista.map { it.uf.toDouble() }.average()

    val formatter = DecimalFormat("#.##", DecimalFormatSymbols(Locale.US))

    return formatter.format(promedio)

}

/*
 2. Función de extensión
    Es una funcion de extnsion por que agrega una nueva función del tipo List<...
    como si fuera un metodo nativo de la clase
    Se cambia la función original para retornar el valor formateado String

    fun List<ChileIndicators>.promedioIPC() = this.map { it.ipc.toDouble() }.average()
*/
fun List<ChileIndicators>.promedioIPC(): String {

    val promedio = this.map { it.ipc.toDouble() }.average()

    val formatter = DecimalFormat("#.##", DecimalFormatSymbols(Locale.US))

    return formatter.format(promedio)

}

/*
    3. Propiedad de extensión

    Consiste en agregar una propiedad al modelo

    Para efectos practicos se dejo en este helper,
    pero lo ideal es que este en extensions ChileIndicatorsExtensions.kt

    En esta ejemplo valorReal es la suma de los tres valores del "primer" registro
*/

val ChileIndicators.valorReal:  BigDecimal
    get() = uf + utm + dolar


/*

  4. Inline function

  Obtiene en una funcion inline el tiempo en filtrar los datos

 */
inline fun medirTiempo(block: () -> Unit): String {
    val inicio = System.currentTimeMillis()
    block()
    return "${System.currentTimeMillis() - inicio} ms"
}

// 5. Try-Catch
fun parsearDolar(valor: String): Double {
    return try {
        valor.toDouble() // Intenta convertir String a Double
    } catch (e: NumberFormatException) {
        -1.0   // Si falla retorna -1.0
    }
}

// 6.- Lambda con filtro
// Esta línea se encuentra en EjemploData.tk
// IndicatorRepository.indicators.filter { it.dolar > BigDecimal(930) }.joinToString { it.date }

// 7.- Lambda con etiqueta
// Esta línea se encuentra en EjemploData.tk @lit es una nombre cualquiera relacionado al lambda
// para identificarlo
// Un lambda con etiqueta es una lambda que tiene un nombre personalizado para identificar
// específicamente a qué lambda debe retornar el return


// 8.- For / if / Else
// Esta línea se encuentra en EjemploData.tk
// buildString: es una función inline de Kotlin que crea un StringBuilder internamente
// y permite construir strings de manera eficiente.
//
// buildString: es la forma eficiente y limpia de construir strings complejos en Kotlin,
// especialmente cuando se trabajan con bucles o lógica condicional etc

// 9.- Do-While
// Esta línea se encuentra en EjemploData.tk