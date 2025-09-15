package cl.duocuc.lumina2.utils

/**
 * Aquí defino variables de uso global
 * Define singleton para una configuración global
 * var es una variable mutable en Kotlin, es decir, se puede  cambiarle el valor después de declararla.
 * userEmail es el nombre de la variable (identificador).
 * String? el tipo de dato.
 * String almacenará texto (por ejemplo "mj.tapia.o@mail.com").
 * El ? indica que la variable puede ser nula. Es decir, puede guardar un String o el valor especial null.
 * = null valor inicial. Se empieza sin ningún correo almacenado.
 */

object Globals {
    var userEmail: String? = null
    var userName: String? = null

    var authUser: Boolean? = false
}
