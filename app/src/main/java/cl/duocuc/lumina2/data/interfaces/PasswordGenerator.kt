package cl.duocuc.lumina2.data.interfaces

// INTERFAZ: implemente generate()
// Toda clase que implemente esta interfaz
// debe tener un metodo generate() de devuelve una contraseña
//
interface PasswordGenerator {
    fun generate(): String
}