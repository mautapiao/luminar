package cl.duocuc.lumina2.data.repository

import androidx.compose.runtime.mutableStateListOf
import cl.duocuc.lumina2.data.dao.UserDao
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
class UserRepository( private val userDao: UserDao) {

    // registrar usuario
    suspend fun register(user: User): Boolean {
        // Verificar si ya existe un usuario con el mismo email
        val existe = userDao.getUserByEmail(user.email)

        return if (existe == null) {
            userDao.insert(user)
            true  // registrado con éxito
        } else {
            false // ya existe correo
        }
    }

    // obtener todos los usuarios
    suspend fun getUsers(): List<User> {
        return userDao.getAll()
    }

    suspend fun seedDefaults() {
        val defaults = listOf(
            User(name = "Ana Pérez", email = "ana@demo.com", password = "123456", country = "Chile"),
            User(name = "Juan López", email = "juan@demo.com", password = "123456", country = "Chile"),
            User(name = "María Díaz", email = "maria@demo.com", password = "123456", country = "Perú"),
            User(name = "Carlos Ruiz", email = "carlos@demo.com", password = "123456", country = "Argentina"),
            User(name = "Lucía Gómez", email = "lucia@demo.com", password = "123456", country = "México")
        )

        defaults.forEach { user ->
            val exists = userDao.getUserByEmail(user.email)
            if (exists == null) {
                userDao.insert(user) // solo inserta si no existe ese email
            }
        }
    }

    // suspend -> etiqueta para funciones que pueden usarse en corrutinas.
    // Login: verificar si existe y coincide contraseña
    suspend fun login(email: String, password: String): Boolean {
        val user = userDao.getUserByEmail(email)
        return user?.password == password
    }

    // Retornar el nombre del usuario
    suspend fun userName(email: String): String? {
        val user = userDao.getUserByEmail(email)
        return user?.name
    }

    // Retornar seguridad de la clave
    suspend fun userPasswordSecurity(email: String): String? {
        val user = userDao.getUserByEmail(email)
        return user?.seguridad()
    }

    // Retornar info del usuario usando showInfo()
    suspend fun userInfo(email: String): String? {
        val user = userDao.getUserByEmail(email)
        return user?.showInfo()
    }


}
