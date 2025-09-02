package cl.duocuc.lumina2.utils

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
