package cl.duocuc.lumina2.utils

import cl.duocuc.lumina2.data.interfaces.PasswordGenerator

// CLASE PADRE
// Esta clase "implementa de interfaz" PasswordGenerator
// Tiene una pripiedad length protegida para que solo la usen las clase hijas
// Genera contraseas simples solo letras y números
open class BasePasswordGenerator(
    protected val length: Int // propiedad
) : PasswordGenerator {
    // metodo que genera una contraseña simple
    override fun generate(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..length).map { chars.random() }.joinToString("")
    }
}