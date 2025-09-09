package cl.duocuc.lumina2.data.repository

import androidx.compose.runtime.mutableStateListOf
import cl.duocuc.lumina2.data.model.User

/**
 *    Clase: User
 *    Objeto: object UserRepository
 *    Propiedades: atributos de User y users en el repo
 *    Métodos: login, register, userName, userPasswordSecurity, etc.
 *    Constructor: implícito en el data class User
 *    Colecciones: mutableStateListOf<User>()
 *    Encapsulación: la lógica de usuarios está dentro del repositorio
 */
object UserRepository {

    // mutableStateListOf => si la lista cambia
    // Colecciones → mutableStateListOf<User>()
    val users = mutableStateListOf<User>()

    // Llenar con 5 usuarios por defecto (una sola vez)
    fun seedDefaultsIfEmpty() {
        if (users.isNotEmpty()) return
        users.addAll(
            listOf(
                User(
                    name = "Ana Pérez",
                    email = "ana@demo.com",
                    password = "123456",
                    country = "Chile"
                ),
                User(
                    name = "Juan López",
                    email = "juan@demo.com",
                    password = "123456",
                    country = "Chile"
                ),
                User(
                    name = "María Díaz",
                    email = "maria@demo.com",
                    password = "123456",
                    country = "Perú"
                ),
                User(
                    name = "Carlos Ruiz",
                    email = "carlos@demo.com",
                    password = "123456",
                    country = "Argentina"
                ),
                User(
                    name = "Lucía Gómez",
                    email = "lucia@demo.com",
                    password = "123456",
                    country = "México"
                ),
            )
        )
    }

    // Registrar un nuevo usuario
    // Retorna false si el correo ya existe
    fun register(user: User): Boolean {
        val exists = users.any { it.email.equals(user.email, ignoreCase = true) }
        if (exists) return false
        users.add(user)
        return true
    }

    // Verificar credenciales para login
    // Retorna true si el email existe y la contraseña coincide
    fun login(email: String, password: String): Boolean {
        val user = users.find { it.email.equals(email, ignoreCase = true) }
        return user?.password == password
    }

    // retornar el nombre del usuario
    fun userName(email: String): String? {
        val user = users.find { it.email.equals(email, ignoreCase = true) }
        return user?.name
    }

    // Retornar seguridad de la clave
    fun userPasswordSecurity(email: String): String? {
        val user = users.find { it.email.equals(email, ignoreCase = true) }
        return user?.seguridad()
    }

    // Retornar info del usuario usando showInfo()
    fun userInfo(email: String): String? {
        val user = users.find { it.email.equals(email, ignoreCase = true) }
        return user?.showInfo()
    }

    // ejemplo
    // val puedeIngresar = UserRepository.login("ana@demo.com", "123456")
    // if (puedeIngresar) {
    //    println("Login exitoso")
    // } else {
    //    println("Correo o contraseña incorrectos")
    //}

}
