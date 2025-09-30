package cl.duocuc.lumina2.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import cl.duocuc.lumina2.data.interfaces.Info

/**
 * Que aplica:
 * Clase User
 * Propiedades (name, email, password, country)
 * Métodos: seguridad()
 * Constructor: el data class
 * Encapsulación: la lógica esta dentro de User
 *
 */

// CLASE: Definición de una clase user
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val country: String
) : Info {
    // CONSTRUCTOR principal con parametros


    // PROPIEDAD calculada: largo de la clave
    @Ignore
    var largoPassword: Int = password.length

    // METODO: Evalúa seguridad de la clave
    fun seguridad(): String {
        if (largoPassword >= 12) {
            return "Tu contraseña es FUERTE"
        } else if (largoPassword >= 8) {
            return "Tu contraseña es MEDIA"
        } else if (largoPassword >= 6) {
            return "Tu contraseña es BAJA"
        } else {
            return "Tu contraseña es MUY DÉBIL"
        }
    }

    // Implementación de la interfaz
    override fun showInfo(): String {
        return "$name, País: $country"
    }

}
